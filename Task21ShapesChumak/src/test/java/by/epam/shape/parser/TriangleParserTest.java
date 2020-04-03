package by.epam.shape.parser;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.exception.InvalidParsingDataException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TriangleParserTest {
    private TriangleParser triangleParser = new TriangleParser();
    private Triangle expectedTriangle = new Triangle();
    private Point pointA;
    private Point pointB;
    private Point pointC;

    @BeforeMethod
    public void setUp() throws Exception {
        pointA = new Point(0,0);
        pointB = new Point(0,1);
        pointC = new Point(1,0);
        expectedTriangle.setId(1);
        expectedTriangle.setA(pointA);
        expectedTriangle.setB(pointB);
        expectedTriangle.setC(pointC);
    }

    @Test
    public void testParseWithValidContent() throws Exception {
        Triangle triangle = triangleParser.parse("1 0 0 0 1 1 0");
        Assert.assertEquals(triangle, expectedTriangle);
    }

    @Test(expectedExceptions = InvalidParsingDataException.class)
    public void testParseWithInvalidContent() throws Exception {
        triangleParser.parse("5 08 28 8 8 8");
    }
}
