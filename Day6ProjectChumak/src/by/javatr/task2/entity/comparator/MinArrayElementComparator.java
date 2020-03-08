package by.javatr.task2.entity.comparator;

import java.util.Comparator;

public class MinArrayElementComparator implements Comparator<int[]> {

    private int findMinElement(int[] array){
        int min = array[0];
        for (int value : array) {
            if (value < min) {
                min = value;
            }
        }
        return min;
    }

    @Override
    public int compare(int[] o1, int[] o2) {
        return findMinElement(o1) - findMinElement(o2);
    }
}
