package by.epam.shape.validator;

import by.epam.shape.exception.FileContentException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleFileValidator {
    private final Pattern trianglePattern = Pattern.compile("(\\d+\\s|\\n){7}");

    public boolean isValidTriangleString(String triangleData){
        boolean condition = false;
        Matcher matcher = trianglePattern.matcher(triangleData);
        if (!triangleData.isEmpty() && matcher.matches()){
            condition = true;
        }
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
        return validatedStrings;
    }
}
