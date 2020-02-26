package by.javatr.task2.entity.comparator;

import by.javatr.exception.NullArgumentException;
import by.javatr.task2.entity.SortingExpression;

public abstract class Comparator {

    public int getComparingResult(int[] firstArray, int[] secondArray, SortingExpression expression) throws NullArgumentException {
        if (firstArray == null){
            throw new NullArgumentException("first array argument is null");
        }
        if (secondArray == null){
            throw new NullArgumentException("second array argument is null");
        }
        if(expression == null){
            throw new NullArgumentException("expression is null");
        }
        int firstValue = firstArray.length == 0 ? Integer.MIN_VALUE : expression.findSortingValue(firstArray);
        int secondValue = secondArray.length == 0 ? Integer.MIN_VALUE : expression.findSortingValue(secondArray);

        if (firstValue == secondValue)
            return 0;
        if (firstValue < secondValue)
            return 1;
        else
            return -1;
    }

    public abstract int compare(int[] firstArray, int[] secondArray) throws NullArgumentException;
}
