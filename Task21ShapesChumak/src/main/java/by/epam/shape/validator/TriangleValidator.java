package by.epam.shape.validator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import by.epam.shape.util.TriangleCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleValidator {

    private static final Logger LOGGER = LogManager.getLogger(TriangleValidator.class);
    private TriangleCalculator triangleCalculator;

    public TriangleValidator(){
        triangleCalculator = new TriangleCalculator();
    }

    public boolean isCorrectPointsString(String triangleCoordinates){
        final String trianglePattern="(\\d+\\s|\\$){7}";
        Pattern p = Pattern.compile(trianglePattern);
        Matcher m = p.matcher(triangleCoordinates);
        return m.matches();
    }

    public boolean isTriangle(Triangle triangle) {
        boolean isTriangle = isTriangle(triangle.getA(), triangle.getB(), triangle.getC());
        LOGGER.info(triangle + " is correct : " + isTriangle);
        return isTriangle;
    }

    public boolean isTriangle(Point a, Point b, Point c){
        boolean isTriangle = true;
        if ((c.getX() - a.getX()) / (b.getX() - a.getX()) == (c.getY() - a.getY()) / (b.getY() - a.getY())) {
            isTriangle = false;
        }
        LOGGER.info(a + " " +b + " " + c + " makes a triangle: " + isTriangle);
        return isTriangle;
    }

    private List<Double> calculateLengths(Triangle triangle){
        List<Double> lengths = new ArrayList<>();
        lengths.add(triangleCalculator.calculateDistance(triangle.getA(),triangle.getB()));
        lengths.add(triangleCalculator.calculateDistance(triangle.getB(),triangle.getC()));
        lengths.add(triangleCalculator.calculateDistance(triangle.getA(),triangle.getC()));
        LOGGER.info("Calculated lengths of the" + triangle);
        return lengths;
    }

    public boolean isEquilateral(Triangle triangle){
        List<Double> lengths = calculateLengths(triangle);
        return (lengths.get(0).equals(lengths.get(1))) & (lengths.get(1).equals(lengths.get(2)));

    }

    public boolean isIsosceles(Triangle triangle){
        List<Double> lengths = calculateLengths(triangle);
        return (lengths.get(0).equals(lengths.get(1))) || (lengths.get(1).equals(lengths.get(2)));
    }

    public boolean isRectangular(Triangle triangle){
        double ab = triangleCalculator.calculateDistance(triangle.getA(),triangle.getB());
        double bc = triangleCalculator.calculateDistance(triangle.getB(),triangle.getC());
        double ac = triangleCalculator.calculateDistance(triangle.getA(),triangle.getC());
        boolean isRectangular = false;
        if (ab*ab + bc*bc == ac*ac || bc*bc + ac*ac == ab*ab || ac*ac + ab*ab == bc*bc){
            isRectangular = true;
        }
        LOGGER.info(triangle + " is rectangular: " + isRectangular);
        return isRectangular;
    }



}
