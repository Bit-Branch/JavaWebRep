package by.epam.shape.reader.impl;

import by.epam.shape.exception.ReadFromFileException;
import by.epam.shape.reader.ShapeFileReader;
import by.epam.shape.validator.TriangleFileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class TriangleFileReader implements ShapeFileReader {
    private static final String DEFAULT_FILEPATH = "src/main/resources/triangles.txt";
       private static final Logger LOGGER = LogManager.getLogger(TriangleFileReader.class);

       public TriangleFileReader() {
       }

       public List<String> readFromFile(String path) throws ReadFromFileException {
           List<String> textLines;
           Path filePath = Paths.get(path);
           try {
               if (Files.exists(filePath)) {
                   LOGGER.info("File found by path: " + path);
                   textLines = Files.readAllLines(Paths.get(path),
                           StandardCharsets.UTF_8);
               }
               else {
                   LOGGER.info("File not found, trying to read info from default file: " + DEFAULT_FILEPATH);
                   textLines = Files.readAllLines(Paths.get(DEFAULT_FILEPATH),
                           StandardCharsets.UTF_8);
               }
           } catch (IOException e) {
               LOGGER.error(e);
               throw new ReadFromFileException("Error during reading from file. Cause: " + e.getMessage());
           }
           LOGGER.info("Finishing reading from file");
           return textLines;
       }
   }

