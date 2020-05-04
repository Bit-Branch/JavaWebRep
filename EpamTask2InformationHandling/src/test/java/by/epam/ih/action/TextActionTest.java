package by.epam.ih.action;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.exception.ComponentException;
import by.epam.ih.exception.ReadFromFileException;
import by.epam.ih.parser.AbstractParser;
import by.epam.ih.parser.impl.ParagraphParser;
import by.epam.ih.reader.Reader;
import by.epam.ih.reader.impl.FileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Path;

import static org.testng.Assert.assertEquals;

public class TextActionTest {
    TextAction action = new TextAction();
    TextComponent textComponent;

    @BeforeMethod
    public void setUp() throws ReadFromFileException, ComponentException {
        Reader reading = new FileReader();
        String sourceTextWithFile = reading.readFile("src/test/java/resources/someText.txt");
        AbstractParser parser = ParagraphParser.getInstance();
        textComponent = parser.parse(sourceTextWithFile);
    }

    @Test
    public void testCalculateIdenticalWords() throws ComponentException {
        long expected = 34;
        long actual = action.calculateIdenticalWords(textComponent);
        assertEquals(actual, expected);
    }
}
