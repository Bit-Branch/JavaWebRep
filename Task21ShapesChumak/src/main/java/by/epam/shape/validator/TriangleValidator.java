package by.epam.shape.validator;

import by.epam.shape.entity.Point;
import by.epam.shape.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.abs;

public class TriangleValidator {
    private static final Logger LOGGER = LogManager.getLogger(TriangleValidator.class);
    private final Pattern TRIANGLE_PATTERN = Pattern.compile("((-?\\d+?\\.?\\d{0,2}\\s){5})(-?\\d+?\\.?\\d{0,2})");

    public TriangleValidator(){
    }

    public boolean isCorrectPointsString(String triangleCoordinates){
        Matcher m = TRIANGLE_PATTERN.matcher(triangleCoordinates);
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

    private double calculateDistance(Point a, Point b) {
        double dx = abs(a.getX() - b.getX());
        double dy = abs(a.getY() - b.getY());
        LOGGER.info("Calculated distance between points: " + a + " and " + b);
        return Math.sqrt(dx*dx + dy*dy);
    }

    private List<Double> calculateLengths(Triangle triangle){
        List<Double> lengths = new ArrayList<>();
        lengths.add(calculateDistance(triangle.getA(),triangle.getB()));
        lengths.add(calculateDistance(triangle.getB(),triangle.getC()));
        lengths.add(calculateDistance(triangle.getA(),triangle.getC()));
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
        double ab = calculateDistance(triangle.getA(),triangle.getB());
        double bc = calculateDistance(triangle.getB(),triangle.getC());
        double ac = calculateDistance(triangle.getA(),triangle.getC());
        boolean isRectangular = false;
        if (ab*ab + bc*bc == ac*ac || bc*bc + ac*ac == ab*ab || ac*ac + ab*ab == bc*bc){
            isRectangular = true;
        }
        LOGGER.info(triangle + " is rectangular: " + isRectangular);
        return isRectangular;
    }



}
