package by.epam.validator;

import by.epam.entity.Point;
import by.epam.entity.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.epam.util.TriangleCalculator.calculateDistance;


public class TriangleValidator {

    private static final Logger LOGGER = LogManager.getLogger(TriangleValidator.class);

    public static boolean isCorrectPointsString(String triangleCoordinates){
        final String trianglePattern="(\\d+\\s|\\$){7}";
        Pattern p = Pattern.compile(trianglePattern);
        Matcher m = p.matcher(triangleCoordinates);
        return m.matches();
    }

    public static boolean isTriangle(Triangle triangle) {

        boolean isTriangle = isTriangle(triangle.getA(), triangle.getB(), triangle.getC());
        LOGGER.info(triangle + " is correct : " + isTriangle);
        return isTriangle;
    }

    public static boolean isTriangle(Point a, Point b, Point c){
        boolean isTriangle = true;
        if ((c.getX() - a.getX()) / (b.getX() - a.getX()) == (c.getY() - a.getY()) / (b.getY() - a.getY())) {
            isTriangle = false;
        }
        return isTriangle;
    }

    private static List<Double> calculateLengths(Triangle triangle){
        List<Double> lengths = new ArrayList<>();
        lengths.add(calculateDistance(triangle.getA(),triangle.getB()));
        lengths.add(calculateDistance(triangle.getB(),triangle.getC()));
        lengths.add(calculateDistance(triangle.getA(),triangle.getC()));
        return lengths;
    }

    public static boolean isEquilateral(Triangle triangle){
        List<Double> lengths = calculateLengths(triangle);
        return (lengths.get(0).equals(lengths.get(1))) & (lengths.get(1).equals(lengths.get(2)));

    }

    public static boolean isIsosceles(Triangle triangle){
        List<Double> lengths = calculateLengths(triangle);
        return (lengths.get(0).equals(lengths.get(1))) || (lengths.get(1).equals(lengths.get(2)));
    }

    public static boolean isRectangular(Triangle triangle){
        double ab = calculateDistance(triangle.getA(),triangle.getB());
        double bc = calculateDistance(triangle.getB(),triangle.getC());
        double ac = calculateDistance(triangle.getA(),triangle.getC());
        boolean isRectangular = false;
        if (ab*ab + bc*bc == ac*ac || bc*bc + ac*ac == ab*ab || ac*ac + ab*ab == bc*bc){
            isRectangular = true;
        }
        return isRectangular;
    }



}
