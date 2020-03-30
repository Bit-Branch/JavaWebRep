package by.epam.validator;

import by.epam.entity.Point;
import by.epam.entity.Triangle;
import by.epam.factory.TriangleFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleValidatorTest {
    private static Triangle triangle;

    @BeforeMethod
    public void setUp() throws Exception {
        Point a = new Point(-3, -2);
        Point b = new Point(0, -1);
        Point c = new Point(-2, 5);
        triangle = TriangleFactory.createTriangle(a, b, c);
    }

    @Test
    public static void testIsEquilateral(){
        Assert.assertFalse(TriangleValidator.isEquilateral(triangle));
    }

    @Test
    public static void testIsIsosceles(){
        Assert.assertFalse(TriangleValidator.isIsosceles(triangle));
    }

    @Test
    public static void testIsRectangular(){
        Assert.assertTrue(TriangleValidator.isRectangular(triangle));
    }
}
