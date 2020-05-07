package by.epam.multithreading.parser;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.exception.InvalidParsingDataException;

public interface ShipParser {
    Ship parse(String shipData) throws InvalidParsingDataException;
}
