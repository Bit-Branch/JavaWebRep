package by.epam.shape.action;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.factory.impl.TriangleFactory;
import by.epam.shape.parser.ShapeParser;
import by.epam.shape.parser.impl.TriangleParser;
import by.epam.shape.reader.ShapeFileReader;
import by.epam.shape.reader.impl.TriangleFileReader;
import by.epam.shape.util.comparator.FirstPointXComparator;
import by.epam.shape.util.comparator.ThirdPointXComparator;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TriangleSorterTest {
    private List<Triangle> triangles = new ArrayList<>();
    private TriangleSorter triangleSorter = new TriangleSorter();
    private List<Triangle> expectedTriangleList = new ArrayList<>();
    private ThirdPointXComparator pointXComparator = new ThirdPointXComparator();

    @BeforeMethod
    public void setUp() throws Exception {
        TriangleFactory triangleFactory = TriangleFactory.getInstance();
        ShapeFileReader reader = new TriangleFileReader();
        List<String> lines = reader.readFromFile("src/triangles.txt");
        ShapeParser<Triangle> parser = new TriangleParser();
        if (triangles.size() == 0) {
            for (String str : lines
            ) {
                try {
                    List<Point> points = parser.parseToPoints(str);
                    triangles.add(triangleFactory.create(points.get(0), points.get(1), points.get(2)));
                } catch (Exception ignored) {
                }
            }
            expectedTriangleList.add(new Triangle(new Point(0, 0), new Point(0, 1), new Point(1, 0)));
            expectedTriangleList.add(new Triangle(new Point(0, 0), new Point(0, 2), new Point(2, 0)));
            expectedTriangleList.add(new Triangle( new Point(1, 1), new Point(1, 2), new Point(3, 3)));
        }
    }

    @Test
    public void testDoBubbleSort() throws Exception {
        triangleSorter.doBubbleSort(triangles,pointXComparator);
        Assert.assertEquals(triangles,expectedTriangleList);
    }

    @Test
    public void testDoQuickSort() throws Exception {
        triangleSorter.doQuickSort(triangles,0,triangles.size()-1,pointXComparator);
        Assert.assertEquals(triangles,expectedTriangleList);
    }

    @Test
    public void testDoInsertionSort() throws Exception {
        triangleSorter.doInsertionSort(triangles,pointXComparator);
        Assert.assertEquals(triangles,expectedTriangleList);
    }

    @Test
    public void testDoSelectionSort() throws Exception {
        triangleSorter.doSelectionSort(triangles,pointXComparator);
        Assert.assertEquals(triangles,expectedTriangleList);
    }

}
