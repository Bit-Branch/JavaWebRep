package by.epam.shape.repository;

import by.epam.shape.entity.Triangle;
import by.epam.shape.factory.impl.TriangleFactory;
import by.epam.shape.repository.specification.TriangleSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleRepository{
    private static final TriangleRepository instance = new TriangleRepository();
    private final List<Triangle> triangles = new ArrayList<>();
    private static final Logger LOGGER = LogManager.getLogger(TriangleRepository.class);

    private TriangleRepository(){}

    public static TriangleRepository getInstance() {
        return instance;
    }

    public void addTriangle(Triangle triangle) {
        triangles.add(triangle);
        LOGGER.info(triangle + " added to repository");
    }

    public void removeTriangle(Triangle triangle) {
        triangles.remove(triangle);
        LOGGER.info(triangle + " removed from repository");
    }

    public void updateTriangle(Triangle triangle) {
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

    public List<Triangle> query(TriangleSpecification specification) {
        List<Triangle> triangleList = new ArrayList<>();
        for (Triangle triangle : triangles){
            if (specification.isSpecified(triangle)){
                triangleList.add(triangle);
            }
        }
        return triangleList;
    }
}
