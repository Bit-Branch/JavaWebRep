package by.epam.multithreading.entity;


import java.util.ArrayDeque;

public class Dock {
    private boolean isBusy;
    private Ship ship;
    private Port port;

    public Dock(boolean isBusy, Port port) {
        this.isBusy = isBusy;
        this.port = port;
    }

    public Dock(boolean isBusy, Ship ship, Port port) {
        this.isBusy = isBusy;
        this.ship = ship;
        this.port = port;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public boolean isBusy() {
        return isBusy;
    }

    public void setBusy(boolean busy) {
        isBusy = busy;
    }

    public void immerse(){
        ship.setContainers(new ArrayDeque<>(port.getContainers(ship.getCapacity())));
        ship.setShipState(ShipState.FULL);
    }

    public void unload(){
        port.addContainers(ship.getContainers());
        ship.setShipState(ShipState.EMPTY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dock dock = (Dock) o;

        return isBusy == dock.isBusy && ship != null ? ship.equals(dock.ship) : dock.ship == null;
    }

    @Override
    public int hashCode() {
        int result = (isBusy ? 1 : 0);
        result = 31 * result + (ship != null ? ship.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "isBusy=" + isBusy +
                ", ship=" + ship;
    }
}