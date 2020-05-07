package by.epam.multithreading.entity;

import by.epam.multithreading.state.ShipState;
import by.epam.multithreading.state.impl.InRouteState;

public class Ship{
    private int containerCount;
    private boolean isFull;
    private int dockNumber;
    private ShipState state;

    public Ship() {
        state = new InRouteState();
    }

    public Ship(int containerCount, boolean isFull, int dockNumber) {
        this.containerCount = containerCount;
        this.isFull = isFull;
        this.dockNumber = dockNumber;
    }

    public int getContainerCount() {
        return containerCount;
    }

    public void setContainerCount(int containerCount) {
        this.containerCount = containerCount;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public int getDockNumber() {
        return dockNumber;
    }

    public void setDockNumber(int dockNumber) {
        this.dockNumber = dockNumber;
    }

    public ShipState getState() {
        return state;
    }

    public void setState(ShipState state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        return containerCount == ship.containerCount &&
                isFull == ship.isFull &&
                dockNumber == ship.dockNumber &&
                state != null ? state.equals(ship.state) : ship.state == null;
    }

    @Override
    public int hashCode() {
        int result = containerCount;
        result = 31 * result + (isFull ? 1 : 0);
        result = 31 * result + dockNumber;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }
}