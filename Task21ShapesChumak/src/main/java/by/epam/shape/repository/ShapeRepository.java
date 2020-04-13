package by.epam.shape.repository;

import by.epam.shape.entity.Shape;

import java.util.Comparator;
import java.util.List;

public interface ShapeRepository<T extends Shape> {
    void add(T shape);

    void remove(T shape);

    void update(T shape);

    List<T> sort(Comparator<T> comparator);

    List<T> query(ShapeSpecification<T> specification);
}
