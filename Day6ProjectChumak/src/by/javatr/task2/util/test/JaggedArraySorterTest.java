package by.javatr.task2.util.test;

import by.javatr.exception.NullArgumentException;
import by.javatr.task2.entity.comparator.*;
import by.javatr.task2.exception.NullArrayException;
import by.javatr.task2.util.JaggedArraySorter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JaggedArraySorterTest {
    private int[][] jaggedArray;

    @Before
    public void setUp(){
        jaggedArray = new int[][] { {1,7,4,7,9}, {5,34,7,3,2,6}, {34,5,4,4} };
    }

    @Test(expected = NullArgumentException.class)
    public void bubbleSortTest_With_Null_Argument() throws NullArgumentException, NullArrayException {
        JaggedArraySorter.bubbleSort(null, new MaxArrayElementComparator());
    }

    @Test
    public void bubbleSortTest_With_Max_Comparator() throws NullArgumentException, NullArrayException {
        int[][] expected = new int[][] { {34,5,4,4}, {5,34,7,3,2,6}, {1,7,4,7,9} };
        JaggedArraySorter.bubbleSort(jaggedArray, new MaxArrayElementComparator(), true);
        Assert.assertArrayEquals(expected,jaggedArray);
    }

    @Test
    public void bubbleSortTest_With_Min_Comparator() throws NullArgumentException, NullArrayException {
        int[][] expected = new int[][] {{1,7,4,7,9}, {5,34,7,3,2,6}, {34,5,4,4} };
        JaggedArraySorter.bubbleSort(jaggedArray, new MinArrayElementComparator(),false);
        Assert.assertArrayEquals(expected,jaggedArray);
    }

    @Test
    public void bubbleSortTest_With_Sum_Comparator() throws NullArgumentException, NullArrayException {
        int[][] expected = new int[][] { {1,7,4,7,9}, {34,5,4,4}, {5,34,7,3,2,6} };
        JaggedArraySorter.bubbleSort(jaggedArray, new ArraySumComparator());
        Assert.assertArrayEquals(expected,jaggedArray);
    }
}
