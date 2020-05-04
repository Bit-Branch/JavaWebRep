package by.epam.ih.reader;

import by.epam.ih.exception.ReadFromFileException;

public interface Reader {
    String readFile(String path) throws ReadFromFileException;
}
