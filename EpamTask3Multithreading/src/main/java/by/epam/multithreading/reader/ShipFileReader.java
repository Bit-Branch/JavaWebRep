package by.epam.multithreading.reader;

import by.epam.multithreading.exception.ReadFromFileException;

import java.util.List;

public interface ShipFileReader {
    List<String> readFromFile(String path) throws ReadFromFileException;
}
