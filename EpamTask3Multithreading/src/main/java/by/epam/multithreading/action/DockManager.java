package by.epam.multithreading.action;

import by.epam.multithreading.entity.Dock;
import by.epam.multithreading.entity.Port;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import by.epam.multithreading.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DockManager {
    private Port port;
    private Semaphore semaphore;
    private ReentrantLock lock = new ReentrantLock();
    private static final Logger LOGGER = LogManager.getLogger(DockManager.class);

    public DockManager(Semaphore semaphore, Port port){
        this.semaphore = semaphore;
        this.port = port;
    }

    public void takeShip(Ship ship) {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            LOGGER.error("Semaphore acquire failed");
            Thread.currentThread().interrupt();
        }
        lock.lock();
        for (Dock dock: port.getDocks()
             ) {
            if (!dock.isBusy()){
                dock.setShip(ship);
                dock.setBusy(true);
                LOGGER.info("Ship " + Thread.currentThread().getName() +" arrived at dock");
                break;
            }
        }
        lock.unlock();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Ship arriving failed");
        }
    }

    public void leaveShip(Dock dock) {
        lock.lock();
        if (dock.getShip().getContainerCount() > (port.getContainersCount()/port.getDocks().size())) {
            LOGGER.info("Ship " + Thread.currentThread().getName() + " leave dock with nothing ");
            dock.setShip(null);
            dock.setBusy(false);
            lock.unlock();
            semaphore.release();
        } else {
            if (dock.getShip().getContainerCount() > 0) {

            } else {

            }
        }
    }
}