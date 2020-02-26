package by.javatr.task2.util.test;

import by.javatr.exception.NullArgumentException;
import by.javatr.task2.entity.SortingOrder;
import by.javatr.task2.entity.comparator.MaxComparator;
import by.javatr.task2.entity.comparator.MinComparator;
import by.javatr.task2.entity.comparator.SumComparator;
import by.javatr.task2.exception.NullArrayException;
import by.javatr.task2.util.ArraySorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArraySorterTest {

    private int[][] jaggedArray;

    @Before
    public void setUp(){
        jaggedArray = new int[][] { {1,7,4,7,9}, {5,34,7,3,2,6}, {34,5,4,4} };
    }

    @Test(expected = NullArgumentException.class)
    public void bubbleSortTest_With_Null_Argument() throws NullArgumentException, NullArrayException {
        ArraySorter.bubbleSort(null, new MaxComparator(), SortingOrder.DESC);
    }

    @Test
    public void bubbleSortTest_With_Max_Comparator() throws NullArgumentException, NullArrayException {
        int[][] expected = new int[][] { {34,5,4,4}, {5,34,7,3,2,6}, {1,7,4,7,9} };
        ArraySorter.bubbleSort(jaggedArray, new MaxComparator(), SortingOrder.DESC);
        Assert.assertArrayEquals(expected,jaggedArray);
    }

    @Test
    public void bubbleSortTest_With_Min_Comparator() throws NullArgumentException, NullArrayException {
        int[][] expected = new int[][] {{1,7,4,7,9}, {5,34,7,3,2,6}, {34,5,4,4} };
        ArraySorter.bubbleSort(jaggedArray, new MinComparator(), SortingOrder.ASC);
        Assert.assertArrayEquals(expected,jaggedArray);
    }

    @Test
    public void bubbleSortTest_With_Sum_Comparator() throws NullArgumentException, NullArrayException {
        int[][] expected = new int[][] { {1,7,4,7,9}, {34,5,4,4}, {5,34,7,3,2,6} };
        ArraySorter.bubbleSort(jaggedArray, new SumComparator(), SortingOrder.ASC);
        Assert.assertArrayEquals(expected,jaggedArray);
    }
}
