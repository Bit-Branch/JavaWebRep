package by.epam.shape.repository.impl.specification;

import by.epam.shape.entity.Triangle;
import by.epam.shape.repository.ShapeSpecification;

public class TriangleIdSpecification implements ShapeSpecification<Triangle> {

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
