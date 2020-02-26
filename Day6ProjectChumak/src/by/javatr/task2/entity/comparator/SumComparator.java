package by.javatr.task2.entity.comparator;

import by.javatr.exception.NullArgumentException;

public class SumComparator extends Comparator {

    private int calculateSum(int[] array){
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    @Override
    public int compare(int[] firstArray, int[] secondArray) throws NullArgumentException {
        return super.getComparingResult(firstArray, secondArray, this::calculateSum);
    }
}