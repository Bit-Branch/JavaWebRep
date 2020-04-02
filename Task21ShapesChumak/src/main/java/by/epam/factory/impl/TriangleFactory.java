package by.epam.factory.impl;

import by.epam.entity.Point;
import by.epam.entity.Triangle;
import by.epam.exception.IncorrectCoordinatesException;
import by.epam.exception.NullPointException;
import by.epam.factory.ShapeFactory;
import by.epam.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleFactory implements ShapeFactory {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);
    private TriangleValidator triangleValidator = new TriangleValidator();
    private static TriangleFactory instance;

    private TriangleFactory(){}

    public static synchronized TriangleFactory getInstance(){
        if (instance == null){
            instance = new TriangleFactory();
        }
        return instance;
    }

    public Triangle create(Point a, Point b, Point c) throws IncorrectCoordinatesException, NullPointException {

        if (triangleValidator.isTriangle(a, b, c)) {
            Triangle triangle = new Triangle(a, b, c);
            LOGGER.info("Created triangle with coordinates: " + a + " " + b + " " + c);
            return triangle;
        } else {
            throw new IncorrectCoordinatesException("Incorrect coordinates");
        }
    }

    public Triangle create(String triangleData) throws IncorrectCoordinatesException, NullPointException {

        Triangle triangle;
        if (triangleValidator.isCorrectPointsString(triangleData)) {
            List<Point> points = coordinatesToPoints(triangleData);
            triangle = create(points.get(1), points.get(2), points.get(3));
            LOGGER.info("Created triangle with coordinates: " + points.get(1) + " " + points.get(2) + " " + points.get(3));
        } else {
            throw new IncorrectCoordinatesException("Incorrect coordinates");
        }
        return triangle;
    }

    private List<Point> coordinatesToPoints(String triangleStr) {

        List<Point> points = new ArrayList<>();
        String[] coordinates = triangleStr.split(" ");
        for (int i = 1; i < coordinates.length; i += 2) {
            points.add(new Point(Double.parseDouble(coordinates[i]), Double.parseDouble(coordinates[i + 1])));
        }
        return points;
    }
}
