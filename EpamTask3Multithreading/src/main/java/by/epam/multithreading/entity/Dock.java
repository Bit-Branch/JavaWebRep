package by.epam.multithreading.entity;

public class Dock {
    private boolean isBusy;
    private Ship ship;

    public Dock() {
    }

    public Dock(boolean isBusy) {
        this.isBusy = isBusy;
    }

    public Dock(boolean isBusy, Ship ship) {
        this.isBusy = isBusy;
        this.ship = ship;
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