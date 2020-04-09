package by.epam.shape.parser;

import by.epam.shape.entity.Point;
import by.epam.shape.exception.InvalidParsingDataException;

import java.util.List;

public interface ShapeParser<T> {
    T parse(String shapeData) throws InvalidParsingDataException;
    List<Point> parseToPoints(String shapeData) throws InvalidParsingDataException;
}
