package by.epam.multithreading.entity;

import by.epam.multithreading.action.DockManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;


public class Port {
    private static Port instance = new Port();
    private List<Dock> docks;
    private Queue<Container> containers;
    private int containersCount;
    private static ReentrantLock lock;
    private static final int DEFAULT_DOCK_COUNT = 7;
    private static final int DEFAULT_STORAGE_CAPACITY = 30;
    private static final Logger LOGGER = LogManager.getLogger(Port.class);
    private static AtomicBoolean initialized;

    private Port() {
        lock = new ReentrantLock();
        initialized = new AtomicBoolean(false);
        docks = new ArrayList<>();
        for (int i =0;i<DEFAULT_DOCK_COUNT;i++){
            docks.add(new Dock(false,this));
        }
        containers = new ArrayDeque<>();
    }

    public static Port getInstance() {
        if (!initialized.get()) {
            instance = new Port();
            initialized.set(true);
        }
        return instance;
    }

    public Dock getFreeDock(){
        lock.lock();
        Dock freeDock = null;
        for (Dock dock:docks
             ) {
            if (!dock.isBusy()){
                freeDock = dock;
            }
        }
        lock.unlock();
        return freeDock;
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

    List<Container> getContainers(int capacity) {
        lock.lock();
        List<Container> containers = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            containers.add(this.containers.poll());
        }
        LOGGER.info("Ship " + Thread.currentThread().getName() +" get containers");
        lock.unlock();
        return containers;
    }

    void addContainers(List<Container> shipContainers) {
        lock.lock();
        containers.addAll(shipContainers);
        lock.unlock();
        LOGGER.info("Ship " + Thread.currentThread().getName() +" remove containers");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Port port = (Port) o;

        return containersCount == port.containersCount &&
                docks != null ? docks.equals(port.docks) : port.docks == null &&
                containers != null ? containers.equals(port.containers) : port.containers == null;
    }

    @Override
    public int hashCode() {
        int result = docks != null ? docks.hashCode() : 0;
        result = 31 * result + containersCount;
        result = 31 * result + (containers != null ? containers.hashCode() : 0);
        return result;
    }
}