package by.javatr.task2.entity.comparator;
import by.javatr.exception.NullArgumentException;

public class MaxComparator extends Comparator {

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
    public int compare(int[] firstArray, int[] secondArray) throws NullArgumentException {
        return super.getComparingResult(firstArray, secondArray, this::findMaxElement);
    }
}
