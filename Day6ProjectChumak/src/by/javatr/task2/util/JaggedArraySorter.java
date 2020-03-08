package by.javatr.task2.util;

import by.javatr.exception.NullArgumentException;
import by.javatr.task2.exception.NullArrayException;

public class JaggedArraySorter {

    public static void bubbleSort(int[][] array, java.util.Comparator<int[]> comparator)
            throws NullArgumentException, NullArrayException {
        sort(array,comparator,false);
    }

    public static void bubbleSort(int[][] array, java.util.Comparator<int[]> comparator,
                                  boolean desc) throws NullArgumentException, NullArrayException {
        sort(array,comparator,desc);
    }

    private static void sort(int[][] array, java.util.Comparator<int[]> comparator,
                                  boolean desc) throws NullArgumentException, NullArrayException {
        if (array == null) {
            throw new NullArgumentException("array argument is null");
        }
        if (comparator == null) {
            throw new NullArgumentException("comparator argument is null");
        }
        if (hasNullArray(array)) {
            throw new NullArrayException("jagged array has null array");
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = array.length - 1; j > i; j--) {
                if (comparator.compare(array[j], array[j - 1]) < 0) {
                    swapRows(array, j, j - 1);
                }
            }
        }
        if (desc) {
            reverseArray(array);
        }
    }

    private static void reverseArray(int[][] array){
        int start = 0;
        int end = array.length-1;
        int[] tempArray;

        while (start < end){
            tempArray = array[start].clone();
            array[start] = array[end].clone();
            array[end] = tempArray.clone();
            start++;
            end--;
        }
    }

    private static void swapRows(int[][] array, int firstRowIndex,int secondRowIndex)
    {
        int[] buffer = array[firstRowIndex].clone();
        array[firstRowIndex] = array[secondRowIndex].clone();
        array[secondRowIndex] = buffer.clone();
    }

    private static boolean hasNullArray(int[][] jaggedArray){
        boolean answer = false;
        for (int[] array : jaggedArray) {
            if (array == null) {
                answer = true;
                break;
            }
        }
        return answer;
    }

}
