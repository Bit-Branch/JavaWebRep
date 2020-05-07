package by.epam.multithreading.entity;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Port {
    private static Port instance = new Port();
    private List<Dock> docks;
    private int containersCount;
    private static final int DEFAULT_DOCK_COUNT = 7;
    private static final int DEFAULT_STORAGE_CAPACITY = 30;

    private Port() {
        docks = new CopyOnWriteArrayList<Dock>();
        for (int i =0;i<DEFAULT_DOCK_COUNT;i++){
            docks.add(new Dock(false));
        }
    }

    public static Port getInstance() {
        return instance;
    }

    public List<Dock> getDocks() {
        List<Dock> docksList = new CopyOnWriteArrayList<Dock>();
        Collections.copy(docksList,docks);
        return docksList;
    }

    public void setDocks(List<Dock> docks) {
        this.docks = docks;
    }

    public int getContainersCount() {
        return containersCount;
    }

    public void setContainersCount(int containersCount) {
        this.containersCount = containersCount;
    }

    public static int getDefaultDockCount() {
        return DEFAULT_DOCK_COUNT;
    }

    public static int getDefaultStorageCapacity() {
        return DEFAULT_STORAGE_CAPACITY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Port port = (Port) o;

        return containersCount == port.containersCount &&
                docks != null ? docks.equals(port.docks) : port.docks == null;
    }

    @Override
    public int hashCode() {
        int result = docks != null ? docks.hashCode() : 0;
        result = 31 * result + containersCount;
        return result;
    }
}