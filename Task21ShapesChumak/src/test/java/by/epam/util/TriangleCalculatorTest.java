package by.epam.util;

import by.epam.entity.Point;
import by.epam.entity.Triangle;
import by.epam.factory.TriangleFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleCalculatorTest {
    Triangle triangle;

    @BeforeMethod
    public void setUp() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        triangle = TriangleFactory.createTriangle(a, b, c);
    }

    @Test
    public void testCalculateArea() throws Exception {
        double eps = 0.000_001;
        double expectedSquare = 0.5;
        Assert.assertEquals(TriangleCalculator.calculateArea(triangle), expectedSquare, eps);
    }

    @Test
    public void testCalculatePerimeter() throws Exception {
        double eps = 0.000_001;
        double expectedPerimeter = 3.41421356;
        Assert.assertEquals(TriangleCalculator.calculatePerimeter(triangle), expectedPerimeter, eps);
    }

}