package by.epam.committiee.bundle;

import by.epam.committiee.pool.ConnectionPool;
import by.epam.committiee.resource.MessageManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static org.testng.Assert.assertTrue;

public class MessageManagerTest {

    @Test
    public void getConnectionTestOverPoolSize() throws IOException, InterruptedException {

        System.out.println(MessageManager.getProperty("message.cantLogIn"));
    }
}
