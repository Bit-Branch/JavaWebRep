package by.epam.shape.repository.impl.specification;

import by.epam.shape.entity.Triangle;
import by.epam.shape.repository.ShapeSpecification;
import by.epam.shape.action.TriangleAction;

public class TrianglePerimeterSpecification implements ShapeSpecification<Triangle> {
    double minPerimeter;
    double maxPerimeter;

    public TrianglePerimeterSpecification(double minPerimeter, double maxPerimeter) {
        this.minPerimeter = minPerimeter;
        this.maxPerimeter = maxPerimeter;
    }

    public double getMinPerimeter() {
        return minPerimeter;
    }

    public void setMinPerimeter(double minPerimeter) {
        this.minPerimeter = minPerimeter;
    }

    public double getMaxPerimeter() {
        return maxPerimeter;
    }

    public void setMaxPerimeter(double maxPerimeter) {
        this.maxPerimeter = maxPerimeter;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        TriangleAction triangleAction = new TriangleAction();
        double perimeter = triangleAction.calculatePerimeter(triangle);
        return perimeter>= minPerimeter && perimeter<=maxPerimeter;
    }
}
