package by.javatr.task2.entity.comparator;

import by.javatr.exception.NullArgumentException;

public class MinComparator extends Comparator {

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
    public int compare(int[] firstArray, int[] secondArray) throws NullArgumentException {
        return super.getComparingResult(firstArray, secondArray, this::findMinElement);
    }
}