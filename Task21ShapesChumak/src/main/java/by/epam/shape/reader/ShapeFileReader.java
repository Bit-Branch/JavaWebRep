package by.epam.shape.reader;

import java.util.List;

public interface ShapeFileReader {
    List<String> readFromFile(String path);
}
