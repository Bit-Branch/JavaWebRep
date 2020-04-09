package by.epam.shape.util.comparator;

import by.epam.shape.entity.Triangle;

import java.util.Comparator;

public class SecondPointXComparator implements Comparator<Triangle> {
    @Override
    public int compare(Triangle o1, Triangle o2) {
        if(o1.getB().getX() > o2.getB().getX()) {
            return 1;
        }
        else if(o1.getB().getX() < o2.getB().getX()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
