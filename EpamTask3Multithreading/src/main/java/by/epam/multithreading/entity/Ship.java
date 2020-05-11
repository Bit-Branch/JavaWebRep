package by.epam.multithreading.entity;

import by.epam.multithreading.state.ShipState;
import by.epam.multithreading.state.impl.InRouteState;

public class Ship extends Thread{
    private long id;
    private int containerCount;
    private ShipState shipState;

    public Ship() {
        shipState = new InRouteState();
    }


    public int getContainerCount() {
        return containerCount;
    }

    public void setContainerCount(int containerCount) {
        this.containerCount = containerCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShipState getShipState() {
        return shipState;
    }

    public void setShipState(ShipState shipState) {
        this.shipState = shipState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        return containerCount == ship.containerCount &&
                id == ship.id &&
                shipState != null ? shipState.equals(ship.shipState) : ship.shipState == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + containerCount;
        result = 31 * result + (shipState != null ? shipState.hashCode() : 0);
        return result;
    }
}