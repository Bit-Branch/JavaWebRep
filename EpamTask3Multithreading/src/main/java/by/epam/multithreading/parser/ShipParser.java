package by.epam.multithreading.parser;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.exception.InvalidParsingDataException;

import java.util.List;

public interface ShipParser {
    Ship parse(String shipData) throws InvalidParsingDataException;
    List<Ship> parse(List<String> shipData) throws InvalidParsingDataException;
}
