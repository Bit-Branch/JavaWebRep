package by.epam.multithreading.state.impl;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.state.ShipState;

public class ChargingState implements ShipState {
    public void next(Ship ship) {
            System.out.println("Ship is charged");
    }

    public void prev(Ship ship) {
        ship.setShipState(new ArrivedState());
    }

    public void printStatus() {
        System.out.println("Ship is in charging state");
    }
}
