package by.epam.factory;

import by.epam.entity.Point;
import by.epam.entity.Shape;
import by.epam.exception.IncorrectCoordinatesException;
import by.epam.exception.NullPointException;

public interface ShapeFactory {
    Shape create(Point a, Point b, Point c) throws IncorrectCoordinatesException, NullPointException;

    Shape create(String triangleCoordinates) throws IncorrectCoordinatesException, NullPointException;
}
