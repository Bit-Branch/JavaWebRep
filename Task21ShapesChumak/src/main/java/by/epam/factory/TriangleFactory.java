package by.epam.factory;

import by.epam.entity.Point;
import by.epam.entity.Triangle;
import by.epam.exception.IncorrectTrianglePointsException;
import by.epam.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);

    public static Triangle createTriangle(Point a, Point b, Point c) throws IncorrectTrianglePointsException {

        if (TriangleValidator.isTriangle(a, b, c)) {
            Triangle triangle = new Triangle(a, b, c);
            LOGGER.info("Created triangle with coordinates: " + a + " " + b + " " + c);
            return triangle;
        } else {
            throw new IncorrectTrianglePointsException("Incorrect coordinates");
        }
    }

    public static Triangle createTriangle(String triangleCoordinates) throws IncorrectTrianglePointsException {

        Triangle triangle;
        if (TriangleValidator.isCorrectPointsString(triangleCoordinates)) {
            List<Point> points = coordinatesToPoints(triangleCoordinates);
            triangle = TriangleFactory.createTriangle(points.get(1), points.get(2), points.get(3));
            LOGGER.info("Created triangle with coordinates: " + points.get(1) + " " + points.get(2) + " " + points.get(3));
        } else {
            throw new IncorrectTrianglePointsException("Incorrect coordinates");
        }
        return triangle;
    }

    private static List<Point> coordinatesToPoints(String triangleStr) {

        List<Point> points = new ArrayList<>();
        String[] coordinates = triangleStr.split(" ");
        for (int i = 1; i < coordinates.length; i += 2) {
            points.add(new Point(Double.parseDouble(coordinates[i]), Double.parseDouble(coordinates[i + 1])));
        }
        return points;
    }
}
