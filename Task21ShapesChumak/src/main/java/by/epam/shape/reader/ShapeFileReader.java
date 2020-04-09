package by.epam.shape.reader;

import by.epam.shape.exception.ReadFromFileException;

import java.util.List;

public interface ShapeFileReader {
    List<String> readFromFile(String path) throws ReadFromFileException;
}
