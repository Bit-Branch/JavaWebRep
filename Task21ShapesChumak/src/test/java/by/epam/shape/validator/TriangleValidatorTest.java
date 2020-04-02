package by.epam.shape.validator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.factory.impl.TriangleFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TriangleValidatorTest {
    private static Triangle triangle;
    private static TriangleValidator triangleValidator = new TriangleValidator();

    @BeforeMethod
    public void setUp() throws Exception {
        Point a = new Point(-3, -2);
        Point b = new Point(0, -1);
        Point c = new Point(-2, 5);
        triangle = TriangleFactory.getInstance().create(a, b, c);
    }

    @Test
    public static void testIsEquilateral(){
        Assert.assertFalse(triangleValidator.isEquilateral(triangle));
    }

    @Test
    public static void testIsIsosceles(){
        Assert.assertFalse(triangleValidator.isIsosceles(triangle));
    }

    @Test
    public static void testIsRectangular(){
        Assert.assertTrue(triangleValidator.isRectangular(triangle));
    }
}
