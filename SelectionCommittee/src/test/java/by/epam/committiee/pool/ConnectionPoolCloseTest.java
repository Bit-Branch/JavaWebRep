package by.epam.committiee.pool;

import by.epam.committiee.exception.PoolIsClosedException;
import org.testng.annotations.Test;


public class ConnectionPoolCloseTest {

    @Test(expectedExceptions = PoolIsClosedException.class)
    public void getInstanceTestClosed() {

        ConnectionPool pool = ConnectionPool.getInstance();
        pool.close();
        ConnectionPool.getInstance();

    }

}
