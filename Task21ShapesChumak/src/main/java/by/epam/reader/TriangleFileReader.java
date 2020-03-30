package by.epam.reader;

import by.epam.validator.TriangleValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TriangleFileReader {
    private static final Logger LOGGER = LogManager.getLogger(TriangleFileReader.class);

    public static List<String> readFromFile(String path) {
        List<String> textLines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(path))) {
            LOGGER.info("Starting reading from file : " + path);
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                if (TriangleValidator.isCorrectPointsString(currentLine)){
                    textLines.add(currentLine);
                }
            }
            LOGGER.info("Finishing reading from file : " + path);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return textLines;
    }
}
