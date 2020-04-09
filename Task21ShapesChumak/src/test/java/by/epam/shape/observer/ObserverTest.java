package by.epam.shape.observer;

import by.epam.shape.action.TriangleAction;
import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.exception.InvalidParsingDataException;
import by.epam.shape.parser.impl.TriangleParser;
import by.epam.shape.warehouse.Warehouse;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ObserverTest {
    private Triangle triangle;
    private TriangleAction triangleAction = new TriangleAction();
    private double area;
    private double perimeter;
    private Warehouse warehouse = Warehouse.getInstance();

    @BeforeMethod
    public void setUp() throws Exception {
        triangle = new Triangle();
        triangle.setId(1);
        triangle.setA(new Point(0,0));
        triangle.setB(new Point(1,0));
        triangle.setC(new Point(0,1));
        area = triangleAction.calculateArea(triangle);
        perimeter = triangleAction.calculatePerimeter(triangle);
    }

    @Test
    public void testChangingValuesInWarehouse() throws Exception {
        Assert.assertEquals(area,warehouse.getProperty(1).getArea());
        triangle.setC(new Point(0,5));
        Assert.assertNotEquals(area,warehouse.getProperty(1).getArea());
    }

}
