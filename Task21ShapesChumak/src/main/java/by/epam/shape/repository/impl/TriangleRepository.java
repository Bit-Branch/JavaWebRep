package by.epam.shape.repository.impl;

import by.epam.shape.entity.Triangle;
import by.epam.shape.repository.ShapeRepository;
import by.epam.shape.repository.ShapeSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleRepository implements ShapeRepository<Triangle> {
    private static final TriangleRepository instance = new TriangleRepository();
    private final List<Triangle> triangles = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(TriangleRepository.class);

    private TriangleRepository(){}

    public static TriangleRepository getInstance() {
        return instance;
    }

    @Override
    public void add(Triangle triangle) {
        triangles.add(triangle);
        LOGGER.info(triangle + " added to repository");
    }

    @Override
    public void remove(Triangle triangle) {
        triangles.remove(triangle);
        LOGGER.info(triangle + " removed from repository");
    }

    @Override
    public void update(Triangle triangle) {
        int index = -1;
        for (int i = 0; i< triangles.size(); i++){
            if (triangles.get(i).getId() == triangle.getId()){
                index = i;
                break;
            }
        }
        if (index != -1){
            triangles.set(index, triangle);
            LOGGER.info(triangle + " updated in repository");
        }
    }

    @Override
    public List<Triangle> sort(Comparator<Triangle> comparator){
        List<Triangle> sortedList = new ArrayList<>(triangles);
        sortedList.sort(comparator);
        LOGGER.info("List: " + triangles + " sorted with comparator: " + comparator);
        return sortedList;
    }

    @Override
    public List<Triangle> query(ShapeSpecification<Triangle> specification) {
        List<Triangle> triangleList = new ArrayList<>();
        for (Triangle triangle : triangles){
            if (specification.isSpecified(triangle)){
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }
}
