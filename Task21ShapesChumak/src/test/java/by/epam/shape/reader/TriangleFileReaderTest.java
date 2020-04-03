package by.epam.shape.reader;

import by.epam.shape.entity.Triangle;
import by.epam.shape.reader.impl.TriangleFileReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleFileReaderTest {
    private TriangleFileReader triangleFileReader = new TriangleFileReader();
    private List<String> expectedContent = new ArrayList<>();

    @BeforeMethod
    public void setUp() throws Exception {
        expectedContent.add("1 0 0 0 1 1 0");
        expectedContent.add("2 0 0 0 2 2 0");
        expectedContent.add("3 1 1 1 2 3 3");
        expectedContent.add("");
        expectedContent.add("4 0 0 1 1 4 4");
        expectedContent.add("5 08 28 8 8 8");
        expectedContent.add("6 8ad 2 2 4 5");
        expectedContent.add("7 1 1 0 0 0 0");
    }

    @Test
    public void testReadFromFile() throws Exception {
        List<String> fileContent = triangleFileReader.readFromFile("src/triangles.txt");
        Assert.assertEquals(fileContent, expectedContent);
    }
}
