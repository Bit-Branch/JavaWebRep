package by.epam.multithreading.entity;

public class Dock {
    private boolean isBusy;

    public Dock() {
    }

    public Dock(boolean isBusy) {
        this.isBusy = isBusy;
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

        return isBusy == dock.isBusy;
    }

    @Override
    public int hashCode() {
        return (isBusy ? 1 : 0);
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "isBusy=" + isBusy;
    }
}