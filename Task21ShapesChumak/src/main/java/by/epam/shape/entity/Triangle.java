package by.epam.shape.entity;

import by.epam.shape.idgenerator.IdGenerator;

public class Triangle extends Shape{

    private int id;

    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
    }

    public Triangle(Point a, Point b, Point c){
        this.id = IdGenerator.generateId();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle(int id, Point a, Point b, Point c){
        this.id = id;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setA(Point a){
        this.a = a;
    }

    public void setB(Point b){
        this.b = b;
    }

    public void setC(Point c){
        this.c = c;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
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