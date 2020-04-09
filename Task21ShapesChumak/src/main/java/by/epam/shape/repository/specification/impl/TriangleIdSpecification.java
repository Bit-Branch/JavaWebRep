package by.epam.shape.repository.specification.impl;

import by.epam.shape.entity.Triangle;
import by.epam.shape.repository.specification.TriangleSpecification;

public class TriangleIdSpecification implements TriangleSpecification {

    private long id;

    public TriangleIdSpecification(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean isSpecified(Triangle triangle) {
        return id == triangle.getId();
    }
}
