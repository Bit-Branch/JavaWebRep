package by.epam.multithreading.parser.impl;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.exception.InvalidParsingDataException;
import by.epam.multithreading.parser.ShipParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShipParserImpl implements ShipParser {

    private static final Logger LOGGER = LogManager.getLogger(ShipParserImpl.class);
    private final String DELIMITER = " ";

    @Override
    public Ship parse(String shipData) throws InvalidParsingDataException {
        String[] data = shipData.split(DELIMITER);
        Ship ship = new Ship();
        ship.setContainerCount(Integer.parseInt(data[0]));
        ship.setDockNumber(Integer.parseInt(data[1]));
        LOGGER.info("Parsed data to ship: " + shipData);
        return ship;
    }
}
