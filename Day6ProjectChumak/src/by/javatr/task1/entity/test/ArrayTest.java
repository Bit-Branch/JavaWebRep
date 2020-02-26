package by.javatr.task1.entity.test;

import by.javatr.task1.entity.Array;
import by.javatr.exception.NullArgumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArrayTest {
    private Array array;

    @Before
    public void setUp(){
        array = new Array(1,6,4,2,7,5);
    }

    @Test
    public void addTest() throws NullArgumentException {
        Array expected = new Array(1,6,4,2,7,5,24);
        array.add(24);
        Assert.assertEquals(expected, array);
    }

    @Test
    public void getTest(){
        Integer expected = 4;
        Integer actual = array.get(2);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void doSelectionSortTest(){
        Array expected = new Array(1,2,4,5,6,7);
        array.doSelectionSort();
        Assert.assertEquals(expected, array);
    }

    @Test
    public void doInsertionSortTest(){
        Array expected = new Array(1,2,4,5,6,7);
        array.doInsertionSort();
        Assert.assertEquals(expected, array);
    }

    @Test
    public void doBubbleSortTest(){
        Array expected = new Array(1,2,4,5,6,7);
        array.doBubbleSort();
        Assert.assertEquals(expected, array);
    }

    @Test
    public void findIndexOfTest() throws NullArgumentException {
        int expected = 3;
        int actual = array.findIndexOf(5);
        Assert.assertEquals(expected,actual);
    }
}
