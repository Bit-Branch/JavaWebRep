package by.epam.multithreading.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Port {
    private static Port instance = new Port();
    private List<Dock> docks;
    private int containersCount;
    private ReentrantLock lock = new ReentrantLock();
    private static final int DEFAULT_DOCK_COUNT = 7;
    private static final int DEFAULT_STORAGE_CAPACITY = 30;

    private Port() {
        docks = new ArrayList<>();
        for (int i =0;i<DEFAULT_DOCK_COUNT;i++){
            docks.add(new Dock(false));
        }
    }

    public static Port getInstance() {
        return instance;
    }

    public List<Dock> getDocks() {
       // List<Dock> docksList;
        lock.lock();
        try {
         //   docksList = new ArrayList<>();
         //   Collections.copy(docksList, docks);
            return docks;
        }finally {
            lock.unlock();
        }
    }

    public void setDocks(List<Dock> docks) {
        lock.lock();
        try {
            this.docks = docks;
        } finally {
            lock.unlock();
        }
    }

    public int getContainersCount() {
        lock.lock();
        try {
            return containersCount;
        } finally {
            lock.unlock();
        }
    }

    public void setContainersCount(int containersCount) {
        lock.lock();
        try {
            this.containersCount = containersCount;
        } finally {
            lock.unlock();
        }
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