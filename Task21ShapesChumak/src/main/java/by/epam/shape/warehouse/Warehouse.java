package by.epam.shape.warehouse;

import by.epam.shape.entity.TriangleProperty;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private Map<Long, TriangleProperty> triangleProperties = new HashMap<>();
    private static Warehouse instance;

    private Warehouse(){}

    public static Warehouse getInstance() {
        if (instance == null){
            instance = new Warehouse();
        }
        return instance;
    }

    public void putProperty(long id, TriangleProperty property){
        triangleProperties.put(id, property);
    }

    public boolean containsProperty(long id){
        return triangleProperties.containsKey(id);
    }

    public TriangleProperty getProperty(long id){
        return triangleProperties.get(id);
    }


}
