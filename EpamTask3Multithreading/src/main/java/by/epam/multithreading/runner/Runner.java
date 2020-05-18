package by.epam.multithreading.runner;

import by.epam.multithreading.action.DockManager;
import by.epam.multithreading.entity.Port;
import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.exception.InvalidParsingDataException;
import by.epam.multithreading.exception.ReadFromFileException;
import by.epam.multithreading.parser.ShipParser;
import by.epam.multithreading.parser.impl.ShipParserImpl;
import by.epam.multithreading.reader.ShipFileReader;
import by.epam.multithreading.reader.impl.ShipFileReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileReader;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Runner {
    private static final Logger LOGGER = LogManager.getLogger(Runner.class);
    private static final String FILE_PATH = "src/main/resources/Ships.txt";

    public static void main(String[] args) throws Exception {
        Runner runner = new Runner();
        runner.run(FILE_PATH);
    }

    private void run(String path) throws InterruptedException {
        for (Thread t : makeThreads(path)) {
            t.start();
        }
    }

    private List<Thread> makeThreads(String path) {
        ShipFileReader reader = new ShipFileReaderImpl();
        ShipParser parser = new ShipParserImpl();
        List<Thread> threads = new ArrayList<>();
        try {
            List<String> strings = reader.readFromFile(path);
            List<Ship> ships = parser.parse(strings);
            for (Ship ship:ships
                 ) {
                threads.add(new Thread(ship));
            }
        } catch (InvalidPathException | ReadFromFileException | InvalidParsingDataException e) {
            LOGGER.error(e.getMessage(), e);

        }
        return threads;
    }
}