package by.epam.ih.reader;

import by.epam.ih.exception.ReadFromFileException;
import by.epam.ih.reader.impl.FileReader;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class FileReaderTest {
    Reader reader;

    @Test
    public void testReadFile() throws ReadFromFileException {
        reader = new FileReader();
        int actualNumber = 1016;
        String line = reader.readFile("src/test/java/resources/someText.txt");
        assertEquals(actualNumber, line.length());
    }
}
