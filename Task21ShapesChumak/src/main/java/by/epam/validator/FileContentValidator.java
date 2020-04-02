package by.epam.validator;

import by.epam.exception.FileContentException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileContentValidator {

    public static List<String> validate(List<String> fileStrings) throws FileContentException {
        if (fileStrings.isEmpty()){
            throw new FileContentException("File is empty");
        }
        List<String> validatedStrings = new ArrayList<>();
        for (String str : fileStrings){
            if (!str.isEmpty()){
                validatedStrings.add(str);
            }
        }
        return validatedStrings;
    }
}
