package by.epam.ih.parser;

import by.epam.ih.composite.TextComponent;
import by.epam.ih.composite.impl.Composite;
import by.epam.ih.exception.ComponentException;
import by.epam.ih.exception.ReadFromFileException;
import by.epam.ih.parser.impl.ParagraphParser;
import by.epam.ih.reader.Reader;
import by.epam.ih.reader.impl.FileReader;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class ParagraphParserTest {
    private String text;

    @BeforeMethod
    public void setUp() throws ReadFromFileException {
        Reader reader = new FileReader();
        text = reader.readFile("src/test/java/resources/someText.txt");
    }

    @Test
    public void parseTest() throws ComponentException {
        int numberOfParagraphs = 3;
        AbstractParser parser = ParagraphParser.getInstance();
        TextComponent component = parser.parse(text);
        assertEquals(numberOfParagraphs,((List<Composite>)component.getChild()).size());
    }
}
