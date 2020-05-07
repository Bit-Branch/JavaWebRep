package by.epam.multithreading.state;

import by.epam.multithreading.entity.Ship;

public interface ShipState {
    void next(Ship ship);
    void prev(Ship ship);
    void printStatus();
}
