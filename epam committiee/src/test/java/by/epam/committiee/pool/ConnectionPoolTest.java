package by.epam.committiee.pool;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class ConnectionPoolTest {

    ConnectionPool pool;
    InputStream inputStream;

    @BeforeMethod
    public void setUp() {
        pool = ConnectionPool.getInstance();
        inputStream = getClass().getClassLoader()
                .getResourceAsStream("resources/database/database.properties");
    }

    @AfterMethod
    public void tearDown() throws IOException {
        pool.close();
        inputStream.close();
    }

    @Test
    public void getConnectionTestOverPoolSize() throws IOException, InterruptedException {

        Properties properties = new Properties();
        properties.load(inputStream);

        int poolSize = Integer.parseInt(properties.getProperty("poolSize"));
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < poolSize; i++) {
            connections.add(pool.getConnection());
        }

        Thread thread = new Thread(() -> pool.getConnection());
        thread.start();
        thread.join(2000);
        assertTrue(thread.isAlive());

        thread.interrupt();
    }
}