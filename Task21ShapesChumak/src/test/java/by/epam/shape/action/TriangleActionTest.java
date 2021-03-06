package by.epam.shape.action;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.factory.impl.TriangleFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleActionTest {
    private Triangle triangle;
    private TriangleAction triangleAction = new TriangleAction();

    @BeforeMethod
    public void setUp() throws Exception {
        Point a = new Point(0, 0);
        Point b = new Point(1, 0);
        Point c = new Point(0, 1);
        triangle = TriangleFactory.getInstance().create(a, b, c);
    }

    @Test
    public void testCalculateArea() throws Exception {
        double eps = 0.000_001;
        double expectedSquare = 0.5;
        Assert.assertEquals(triangleAction.calculateArea(triangle), expectedSquare, eps);
    }

    @Test
    public void testCalculatePerimeter() throws Exception {
        double eps = 0.000_001;
        double expectedPerimeter = 3.41421356;
        Assert.assertEquals(triangleAction.calculatePerimeter(triangle), expectedPerimeter, eps);
    }

}