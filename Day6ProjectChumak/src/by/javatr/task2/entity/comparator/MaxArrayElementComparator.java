package by.javatr.task2.entity.comparator;

import java.util.Comparator;

public class MaxArrayElementComparator implements Comparator<int[]> {

    private int findMaxElement(int[] array){
        int max = array[0];
        for (int value : array) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    @Override
    public int compare(int[] o1, int[] o2) {
        return findMaxElement(o1) - findMaxElement(o2);
    }
}
