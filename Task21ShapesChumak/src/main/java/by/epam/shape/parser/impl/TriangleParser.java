package by.epam.shape.parser.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.exception.InvalidParsingDataException;
import by.epam.shape.parser.ShapeParser;
import by.epam.shape.validator.TriangleFileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleParser implements ShapeParser<Triangle> {
    private static final Logger LOGGER = LogManager.getLogger(TriangleParser.class);
    private final String DELIMITER = " ";

    @Override
    public Triangle parse(String triangleData) throws InvalidParsingDataException {
        List<Point> points = parseToPoints(triangleData);
        return new Triangle(points.get(0),points.get(1),points.get(2));
    }

    @Override
    public List<Point> parseToPoints(String triangleData) throws InvalidParsingDataException  {
        TriangleFileValidator fileContentValidator = new TriangleFileValidator();
        if (!fileContentValidator.isValidTriangleString(triangleData)){
            LOGGER.error("Invalid data while parsing");
            throw new InvalidParsingDataException();
        }
        List<Point> points = new ArrayList<>();
        String[] coordinates = triangleData.split(DELIMITER);
        for (int i = 0; i < coordinates.length; i += 2) {
            points.add(new Point(Double.parseDouble(coordinates[i]), Double.parseDouble(coordinates[i + 1])));
        }
        return points;
    }

}
