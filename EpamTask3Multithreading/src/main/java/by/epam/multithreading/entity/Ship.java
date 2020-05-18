package by.epam.multithreading.entity;

import by.epam.multithreading.action.DockManager;

import by.epam.multithreading.util.idGenerator.IdGenerator;

import javax.print.Doc;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Ship implements Runnable{
    private long id;
    private int capacity;
    private ShipState shipState;
    private Queue<Container> containers;

    public Ship() {
        id = IdGenerator.generateId();
        shipState = ShipState.EMPTY;
        containers = new ArrayDeque<>();
    }

    public Ship(int capacity){
        id = IdGenerator.generateId();
        this.capacity = capacity;
        containers = new ArrayDeque<>();
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ShipState getShipState() {
        return shipState;
    }

    public void setShipState(ShipState shipState) {
        this.shipState = shipState;
    }

    public Container getContainer(){
        return containers.poll();
    }

    public void addContainer(Container container){
        containers.add(container);
    }

    public List<Container> getContainers(){
        List<Container> containers = new ArrayList<>(this.containers);
        this.containers.clear();
        return containers;
    }

    public void setContainers(Queue<Container> containers){
        this.containers = containers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ship ship = (Ship) o;

        return capacity == ship.capacity &&
                id == ship.id &&
                shipState != null ? shipState.equals(ship.shipState) : ship.shipState == null &&
                containers != null ? containers.equals(ship.containers) : ship.containers == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + capacity;
        result = 31 * result + (shipState != null ? shipState.hashCode() : 0);
        result = 31 * result + (containers != null ? containers.hashCode() : 0);
        return result;
    }

    @Override
    public void run() {
        DockManager dockManager = DockManager.getInstance();
        dockManager.takeShip(this);
    }
}