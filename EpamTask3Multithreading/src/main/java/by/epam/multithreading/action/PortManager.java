package by.epam.multithreading.action;

import by.epam.multithreading.entity.Port;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import by.epam.multithreading.entity.Ship;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PortManager {
    private Port port;
    private Semaphore semaphore;
    private ReentrantLock lock = new ReentrantLock();
    private static final Logger LOGGER = LogManager.getLogger(PortManager.class);

    public PortManager(Semaphore semaphore, Port port){
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
        int j = 0;
        boolean b = false;
        while (!b && j<port.getDocks().size()){
            if (!port.getDocks().get(j).isBusy()){
                port.getDocks().get(j).setBusy(true);
                ship.setDockNumber(j);
                b = true;
            }
            j++;
        }
        LOGGER.info("Ship " + ship +" arrived at dock " + ship.getDockNumber());
        lock.unlock();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.error("Ship arriving failed");
        }
    }

    public void leaveShip(Ship ship) {
        //--
    }
}