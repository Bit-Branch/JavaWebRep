package by.epam.shape.warehouse;

import by.epam.shape.action.TriangleAction;
import by.epam.shape.entity.Triangle;
import by.epam.shape.entity.TriangleProperty;
import by.epam.shape.observer.Observer;
import by.epam.shape.validator.TriangleFileValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WarehouseObserver implements Observer {
    private static WarehouseObserver instance;
    private static final Logger LOGGER = LogManager.getLogger(WarehouseObserver.class);

    private WarehouseObserver(){}

    public static WarehouseObserver getInstance(){
        if (instance == null){
            instance = new WarehouseObserver();
        }
        return instance;
    }

    @Override
    public void update(Triangle triangle){
        TriangleAction triangleAction = new TriangleAction();
        double area = triangleAction.calculateArea(triangle);
        double perimeter = triangleAction.calculateArea(triangle);
        TriangleProperty triangleProperty;
        Warehouse warehouse = Warehouse.getInstance();
        if (warehouse.containsProperty(triangle.getId())){
            triangleProperty = warehouse.getProperty(triangle.getId());
        } else {
            triangleProperty = new TriangleProperty();
        }
        triangleProperty.setArea(area);
        triangleProperty.setPerimeter(perimeter);
        warehouse.putProperty(triangle.getId(), triangleProperty);
        LOGGER.info("Triangle with id " + triangle.getId() + " updated in warehouse");
    }
}
