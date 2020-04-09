package by.epam.shape.repository.specification.impl;

import by.epam.shape.entity.Triangle;
import by.epam.shape.repository.specification.TriangleSpecification;
import by.epam.shape.action.TriangleAction;

public class TriangleAreaSpecification implements TriangleSpecification {
    private double minArea;
    private double maxArea;

    public TriangleAreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    public double getMinArea() {
        return minArea;
    }

    public void setMinArea(double minArea) {
        this.minArea = minArea;
    }

    public double getMaxArea() {
        return maxArea;
    }

    public void setMaxArea(double maxArea) {
        this.maxArea = maxArea;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        TriangleAction triangleAction = new TriangleAction();
        double area = triangleAction.calculateArea(triangle);
        return area >= minArea && area<=maxArea;
    }
}
