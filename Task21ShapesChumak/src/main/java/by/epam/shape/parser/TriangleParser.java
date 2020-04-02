package by.epam.shape.parser;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.exception.InvalidParsingDataException;
import by.epam.shape.validator.FileContentValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleParser {
    private static final Logger LOGGER = LogManager.getLogger(TriangleParser.class);
    
    public Triangle parse(String triangleData) throws InvalidParsingDataException {
        FileContentValidator fileContentValidator = new FileContentValidator();
        if (!fileContentValidator.isValidTriangleString(triangleData)){
            LOGGER.error("Invalid data while parsing");
            throw new InvalidParsingDataException();
        }
        Triangle triangle = new Triangle();
        String[] valuesArray = triangleData.split(" ");
        triangle.setId(Integer.parseInt(valuesArray[0]));
        triangle.setA(new Point(Double.parseDouble(valuesArray[1]),Double.parseDouble(valuesArray[2])));
        triangle.setB(new Point(Double.parseDouble(valuesArray[3]),Double.parseDouble(valuesArray[4])));
        triangle.setC(new Point(Double.parseDouble(valuesArray[5]),Double.parseDouble(valuesArray[6])));
        return triangle;
    }

}
