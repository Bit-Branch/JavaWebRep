package by.epam.multithreading.action;

import by.epam.multithreading.entity.Dock;
import by.epam.multithreading.entity.Port;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

import by.epam.multithreading.entity.Ship;
import by.epam.multithreading.entity.ShipState;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DockManager {
    private static DockManager instance = new DockManager();
    private Port port;
    private static ReentrantLock lock;
    private static final Logger LOGGER = LogManager.getLogger(DockManager.class);
    private static AtomicBoolean initialized;

    private DockManager(){
        lock = new ReentrantLock();
        initialized = new AtomicBoolean(false);
        this.port = Port.getInstance();
    }

    public static DockManager getInstance() {
        if (!initialized.get()) {
            lock.lock();
            try {
                if (!initialized.get()) {
                    instance = new DockManager();
                    initialized.set(true);
                }
            } finally {
                if (lock.isLocked()) {
                    lock.unlock();
                }
            }
        }
        return instance;
    }

    public void takeShip(Ship ship) {
        lock.lock();
        Dock freeDock = port.getFreeDock();
        if (freeDock != null) {
            freeDock.setBusy(true);
            freeDock.setShip(ship);
            LOGGER.info("Ship " + Thread.currentThread().getName() + " arrived at dock");
            if (freeDock.getShip().getShipState() == ShipState.EMPTY) {
                freeDock.immerse();
            } else {
                freeDock.unload();
            }
        }
        freeDock.setShip(null);
        freeDock.setBusy(false);
        lock.unlock();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Ship arriving failed");
        }
    }
}