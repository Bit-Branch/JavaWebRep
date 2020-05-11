package by.epam.multithreading.state.impl;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.state.ShipState;

public class ArrivedState implements ShipState {
    public void next(Ship ship) {
        ship.setShipState(new ChargingState());
    }

    public void prev(Ship ship) {
        ship.setShipState(new InRouteState());
    }

    public void printStatus() {
        System.out.println("Ship is arrived");
    }
}
