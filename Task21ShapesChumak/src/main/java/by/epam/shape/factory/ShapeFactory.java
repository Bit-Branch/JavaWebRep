package by.epam.shape.factory;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Shape;
import by.epam.shape.exception.IncorrectCoordinatesException;
import by.epam.shape.exception.NullPointException;

public interface ShapeFactory {
    Shape create(Point a, Point b, Point c) throws IncorrectCoordinatesException, NullPointException;

    Shape create(String triangleCoordinates) throws IncorrectCoordinatesException, NullPointException;
}
