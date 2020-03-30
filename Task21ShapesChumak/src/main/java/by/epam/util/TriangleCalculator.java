package by.epam.util;

import by.epam.entity.Point;
import by.epam.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.abs;

public class TriangleCalculator {
    private static final Logger LOGGER = LogManager.getLogger(TriangleCalculator.class);

    public static double calculateArea(Triangle triangle) {
        Point a = triangle.getA();
        Point b = triangle.getB();
        Point c = triangle.getC();
        return (a.getX()*(b.getY() -c.getY()) + b.getX()*(c.getY() -a.getY()) + c.getX()*(a.getY() - b.getY()))/2;
    }

    public static double calculatePerimeter(Triangle triangle) {

        List<Double> lengths = calculateSideLengths(triangle);
        double perimeter = 0;
        for (double length:lengths
             ) {
            perimeter+= length;
        }
        LOGGER.info("Perimeter of the" + triangle + " is " + perimeter);
        return perimeter;
    }

    private static List<Double> calculateSideLengths(Triangle triangle){
        List<Double> sides =new ArrayList<>();
        sides.add(calculateDistance(triangle.getA(),triangle.getB()));
        sides.add(calculateDistance(triangle.getB(),triangle.getC()));
        sides.add(calculateDistance(triangle.getC(),triangle.getA()));
        return sides;
    }

    public static double calculateDistance(Point a, Point b) {
        double dx = abs(a.getX() - b.getX());
        double dy = abs(a.getY() - b.getY());
        return Math.sqrt(dx*dx + dy*dy);
    }
}
