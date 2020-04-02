package by.epam.shape.reader.impl;

import by.epam.shape.reader.ShapeFileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class TriangleFileReader implements ShapeFileReader {
       private static final Logger LOGGER = LogManager.getLogger(TriangleFileReader.class);

       public TriangleFileReader() {
           LOGGER.info("TriangleFileReader created.");
       }

       public List<String> readFromFile(final String path) {
           List<String> textLines = new ArrayList<>();
           try {
               textLines = Files.readAllLines(Paths.get(path),
                       StandardCharsets.UTF_8);
           } catch (IOException e) {
               LOGGER.error(e);
           }
           LOGGER.info("Finishing reading from file: " + path);
           return textLines;
       }
   }

