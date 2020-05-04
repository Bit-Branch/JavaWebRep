package by.epam.ih.reader.impl;

import by.epam.ih.exception.ReadFromFileException;
import by.epam.ih.reader.Reader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileReader implements Reader {
    private static final String DEFAULT_FILEPATH = "src/main/resources/text.txt";
    private static final Logger LOGGER = LogManager.getLogger(FileReader.class);

    public FileReader() {
    }

    public String readFile(String path) throws ReadFromFileException {
        String content = "";
        Path filePath = Paths.get(path);
        try {
            if (Files.exists(filePath)) {
                LOGGER.info("File found by path: " + path);
                content = new String(Files.readAllBytes(Paths.get(path)));
            } else {
                LOGGER.info("File not found, trying to read info from default file: " + DEFAULT_FILEPATH);
                content = new String(Files.readAllBytes(Paths.get(DEFAULT_FILEPATH)));
            }
        } catch (IOException e) {
            LOGGER.error(e);
            throw new ReadFromFileException("Error during reading from file. Cause: " + e.getMessage());
        }
        LOGGER.info("Finishing reading from file");
        return content;
    }
}
