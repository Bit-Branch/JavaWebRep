package by.epam.shape.repository;

import by.epam.shape.entity.Shape;
import by.epam.shape.entity.Triangle;

public interface ShapeSpecification<T extends Shape>{
    boolean isSpecified(T shape);
}
