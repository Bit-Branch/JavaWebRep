package by.javatr.task2.entity.comparator;

import java.util.Comparator;

public class ArraySumComparator implements Comparator<int[]> {

    private int calculateSum(int[] array){
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int compare(int[] o1, int[] o2) {
        return calculateSum(o1) - calculateSum(o2);
    }
}
