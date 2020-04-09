package by.epam.shape.repository.specification.impl;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.repository.specification.TriangleSpecification;

public class TriangleDistanceSpecification implements TriangleSpecification {
    private Point boundaryPoint;

    public TriangleDistanceSpecification(Point boundaryPoint){
        this.boundaryPoint = boundaryPoint;
    }

    private boolean isLessThanBoundaryPoint(Point point){
        boolean firstCondition;
        boolean secondCondition;
        if (boundaryPoint.getX() < 0){
            firstCondition = point.getX() > boundaryPoint.getX();
        }
        else {
            firstCondition = point.getX() < boundaryPoint.getX();
        }
        if (boundaryPoint.getY() < 0){
            secondCondition = point.getY() > boundaryPoint.getY();
        }
        else {
            secondCondition = point.getY() < boundaryPoint.getY();
        }
        return firstCondition && secondCondition;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        return isLessThanBoundaryPoint(triangle.getA()) &&
                isLessThanBoundaryPoint(triangle.getB()) &&
                isLessThanBoundaryPoint(triangle.getC());
    }
}
