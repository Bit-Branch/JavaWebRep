package by.epam.multithreading.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShipQueue {

    private List<Ship> queue;

    public ShipQueue(){
        queue = new ArrayList<>();
    }

    public ShipQueue(List<Ship> list){
        queue = new ArrayList<>(list);
    }

    public boolean addToQueue(Ship ship) {
        return queue.add(ship);
    }

    public Ship getFromQueue() {
        if (queue.isEmpty())
            return null;
        return queue.remove(0);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShipQueue shipQueue = (ShipQueue) o;

        return queue != null ? queue.equals(shipQueue.queue) : shipQueue.queue == null;
    }

    @Override
    public int hashCode() {
        return queue != null ? queue.hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getName() +
                "queue=" + queue;
    }
}