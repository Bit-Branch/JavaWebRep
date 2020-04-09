package by.epam.shape.entity;

import by.epam.shape.observer.ObservableShape;
import by.epam.shape.observer.Observer;
import by.epam.shape.util.idgenerator.IdGenerator;
import by.epam.shape.warehouse.WarehouseObserver;

import java.util.ArrayList;
import java.util.List;

public class Triangle extends Shape implements ObservableShape {

    private long id;

    private Point a;
    private Point b;
    private Point c;

    private List<Observer> observers = new ArrayList<>();

    public Triangle() {
        a = new Point();
        b = new Point();
        c = new Point();
        observers.add(WarehouseObserver.getInstance());
    }

    public Triangle(Point a, Point b, Point c){
        this.id = IdGenerator.generateId();
        this.a = a;
        this.b = b;
        this.c = c;
        observers.add(WarehouseObserver.getInstance());
    }

    public Triangle(long id, Point a, Point b, Point c){
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
        observers.add(WarehouseObserver.getInstance());
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer: observers
             ) {
            observer.update(this);
        }
    }

    public void setA(Point a){
        this.a = a;
        notifyObservers();
    }

    public void setB(Point b){
        this.b = b;
        notifyObservers();
    }

    public void setC(Point c){
        this.c = c;
        notifyObservers();
    }

    public void setId(long id) {
        this.id = id;
        notifyObservers();
    }

    public long getId(){
        return id;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;

        Triangle triangle = (Triangle) o;

        return a != null ? a.equals(triangle.a) : a == triangle.a &&
        b != null ? b.equals(triangle.b) : b == triangle.b &&
        c != null ? c.equals(triangle.c) : c == triangle.c;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + (a != null ? a.hashCode() : 0);
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (c != null ? c.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + "@" +
                "id=" + id +
                ", a=" + a +
                ", b=" + b +
                ", c=" + c;
    }
}