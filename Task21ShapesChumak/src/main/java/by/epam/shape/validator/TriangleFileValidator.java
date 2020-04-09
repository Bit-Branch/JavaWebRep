package by.epam.shape.validator;

import by.epam.shape.exception.FileContentException;
import by.epam.shape.repository.TriangleRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleFileValidator {
    private final Pattern TRIANGLE_PATTERN = Pattern.compile("((-?\\d+?\\.?\\d{0,2}\\s){5})(-?\\d+?\\.?\\d{0,2})");
    private static final Logger LOGGER = LogManager.getLogger(TriangleFileValidator.class);

    public boolean isValidTriangleString(String triangleData){
        boolean condition = false;
        Matcher matcher = TRIANGLE_PATTERN.matcher(triangleData);
        if (!triangleData.isEmpty() && matcher.matches()){
            condition = true;
        }
        LOGGER.info("String " + triangleData + " is valid: " + condition);
        return condition;
    }

    public List<String> validate(List<String> fileStrings) throws FileContentException {
        if (fileStrings.isEmpty()){
            throw new FileContentException("File is empty");
        }
        List<String> validatedStrings = new ArrayList<>();
        for (String str : fileStrings){
            if (isValidTriangleString(str)){
                validatedStrings.add(str);
            }
        }
        LOGGER.info("Strings " + fileStrings + " has valid strings: " + validatedStrings);
        return validatedStrings;
    }
}
