package by.epam.shape.entity;

public class TriangleProperty {
    private double area;
    private double perimeter;

    public TriangleProperty() {
    }

    public TriangleProperty(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }
}
