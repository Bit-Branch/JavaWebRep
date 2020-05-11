package by.epam.multithreading.state.impl;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.state.ShipState;

public class InRouteState implements ShipState {
    public void next(Ship ship) {
        ship.setShipState(new ArrivedState());
    }

    public void prev(Ship ship) {
        System.out.println("Ship is in route");
    }

    public void printStatus() {
        System.out.println("Ship is in route");
    }
}
