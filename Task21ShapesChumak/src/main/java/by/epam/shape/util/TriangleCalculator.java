package by.epam.shape.util;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class TriangleCalculator {
    private final Logger LOGGER = LogManager.getLogger(TriangleCalculator.class);

    public double calculateArea(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        double area = (a.getX()*(b.getY() -c.getY()) + b.getX()*(c.getY() -a.getY()) + c.getX()*(a.getY() - b.getY()))/2;
        LOGGER.info("Calculated area of the" + triangle + ": " + area);
        return area;
    }

    public double calculatePerimeter(Triangle triangle) {

        List<Double> lengths = calculateSideLengths(triangle);
        double perimeter = 0;
        for (double length:lengths
             ) {
            perimeter+= length;
        }
        LOGGER.info("Calculated perimeter of the" + triangle + ": " + perimeter);
        return perimeter;
    }

    private List<Double> calculateSideLengths(Triangle triangle){
        List<Double> sides =new ArrayList<>();
        sides.add(calculateDistance(triangle.getA(),triangle.getB()));
        sides.add(calculateDistance(triangle.getB(),triangle.getC()));
        sides.add(calculateDistance(triangle.getC(),triangle.getA()));
        LOGGER.info("Calculated sides lengths");
        return sides;
    }

    public double calculateDistance(Point a, Point b) {
        double dx = abs(a.getX() - b.getX());
        double dy = abs(a.getY() - b.getY());
        LOGGER.info("Calculated distance between points: " + a + " and " + b);
        return Math.sqrt(dx*dx + dy*dy);
    }
}
