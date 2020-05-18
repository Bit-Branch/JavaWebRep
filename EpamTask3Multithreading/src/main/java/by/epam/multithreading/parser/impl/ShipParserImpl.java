package by.epam.multithreading.parser.impl;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.exception.InvalidParsingDataException;
import by.epam.multithreading.parser.ShipParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ShipParserImpl implements ShipParser {

    private static final Logger LOGGER = LogManager.getLogger(ShipParserImpl.class);
    private final String DELIMITER = " ";

    @Override
    public Ship parse(String shipData) {
        Ship ship = new Ship(Integer.parseInt(shipData));
        LOGGER.info("Parsed data to ship: " + shipData);
        return ship;
    }

    @Override
    public List<Ship> parse(List<String> shipData) {
        List<Ship> ships = new ArrayList<>();
        for (String str:shipData
             ) {
            ships.add(parse(str));
        }
        LOGGER.info("Parsed data to ships: " + shipData);
        return ships;
    }
}
