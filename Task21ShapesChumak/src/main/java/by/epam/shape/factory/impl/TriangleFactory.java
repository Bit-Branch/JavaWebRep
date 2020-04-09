package by.epam.shape.factory.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.exception.IncorrectCoordinatesException;
import by.epam.shape.factory.ShapeFactory;
import by.epam.shape.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleFactory implements ShapeFactory {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFactory.class);
    private static TriangleFactory instance;

    private TriangleFactory(){}

    public static TriangleFactory getInstance(){
        if (instance == null){
            instance = new TriangleFactory();
        }
        return instance;
    }

    public Triangle create(Point a, Point b, Point c) throws IncorrectCoordinatesException {
        TriangleValidator triangleValidator = new TriangleValidator();
        if (!triangleValidator.isTriangle(a, b, c)) {
            throw new IncorrectCoordinatesException("Incorrect coordinates");
        } else {
            Triangle triangle = new Triangle(a, b, c);
            LOGGER.info("Created triangle with coordinates: " + a + " " + b + " " + c);
            return triangle;
        }
    }
}
