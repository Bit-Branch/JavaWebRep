package by.epam.multithreading.state.impl;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.state.ShipState;

public class ChargingState implements ShipState {
    public void next(Ship ship) {
        if (ship.isFull()){
            System.out.println("Ship is already charged");
        }
        else {
            System.out.println("Ship is unloaded");
        }
    }

    public void prev(Ship ship) {
        ship.setState(new ArrivedState());
    }

    public void printStatus() {
        System.out.println("Ship is in charging state");
    }
}
