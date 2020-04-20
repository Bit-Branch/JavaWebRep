package by.epam.ih.reader;

import by.epam.ih.exception.ReadFromFileException;

import java.util.List;

public interface Reader {
    List<String> readFromFile(String path) throws ReadFromFileException;
}
