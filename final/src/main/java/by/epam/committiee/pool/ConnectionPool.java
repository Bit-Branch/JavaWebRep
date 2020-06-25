package by.epam.committiee.pool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import by.epam.committiee.exception.PoolIsClosedException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionPool implements AutoCloseable {
    private static Logger logger = LogManager.getLogger(ConnectionPool.class);
    private static final String POOL_SIZE_KEY = "poolSize";
    private static final String DB_URL_KEY = "url";
    private static final String USER_KEY = "user";
    private static final String PASSWORD_KEY = "password";
    private static final String DB_INFO_PATH = "webres/database/database.properties";
    private static final String DRIVER_KEY = "driver";
    private final BlockingQueue<Connection> pool;
    private static boolean isClosed;

    private ConnectionPool() {
        try(InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream(DB_INFO_PATH)) {

            Properties prop = new Properties();
            prop.load(is);

            pool = new ArrayBlockingQueue<Connection>(
                    Integer.parseInt(prop.getProperty(POOL_SIZE_KEY)));

            logger.debug(prop.getProperty(DRIVER_KEY));
            Class.forName(prop.getProperty(DRIVER_KEY)).newInstance();

            for (int i = 0; i < Integer.parseInt(prop.getProperty(POOL_SIZE_KEY)); i++) {
                Connection conn = DriverManager.getConnection(
                        prop.getProperty(DB_URL_KEY),
                        prop.getProperty(USER_KEY),
                        prop.getProperty(PASSWORD_KEY));

                pool.add(conn);
            }
        } catch (SQLException | InstantiationException |
                IllegalAccessException | ClassNotFoundException e) {
            logger.fatal("Could not connect to DataBase: ",e);
            throw new RuntimeException("Could not connect to DataBase: ",e);
        } catch (IOException e) {
            logger.fatal("Error loading properties file: " + e);
            throw new RuntimeException("Error loading properties file: ",e);
        }
    }

    private static class ConnectionPoolHolder {
        private static final ConnectionPool instance = new ConnectionPool();
    }

    public static ConnectionPool getInstance() {
        if (isClosed) {
            logger.fatal("Pool was already closed");
            throw new PoolIsClosedException();
        }

        return ConnectionPoolHolder.instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = pool.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    @Override
    public void close() {
        try {
        while (!pool.isEmpty()) {
                pool.remove().close();
            }
        registerDrivers();
        isClosed = true;
        } catch (SQLException e) {
                logger.error("Couldn't close connection: ",e);
        }
    }

    private void registerDrivers(){
        try {
            Enumeration<Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()) {
                Driver driver = drivers.nextElement();
                DriverManager.deregisterDriver(driver);
            }
        } catch (SQLException e) {
            logger.error("DriverManager wasn't found.",e);
        }
    }

}