package by.epam.entity;

import by.epam.exception.NullPointException;
import by.epam.idgenerator.IdGenerator;

public class Triangle extends Shape{

    private int id;

    private Point a;
    private Point b;
    private Point c;

    public Triangle() {
    }

    public Triangle(Point a, Point b, Point c){
        this.id = IdGenerator.generateId();
        setA(a);
        setB(b);
        setC(c);
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

        if (a != null ? !a.equals(triangle.a) : triangle.a != null){ return false;}
        if (b != null ? !b.equals(triangle.b) : triangle.b != null){ return false;}
        return c != null ? c.equals(triangle.c) : triangle.c == null;
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