package by.javatr.task1.util.test;

import by.javatr.task1.entity.Array;
import by.javatr.exception.NullArgumentException;
import by.javatr.task1.exception.ZeroSizeException;
import by.javatr.task1.util.ArrayService;
import org.junit.Assert;
import org.junit.Test;

public class ArrayServiceTest {

    @Test(expected = NullArgumentException.class)
    public void findAllPrimeNumbersTest_With_Null_Array() throws NullArgumentException {
        Array array = null;
        ArrayService.findAllPrimeNumbers(array);
    }

    @Test
    public void findAllPrimeNumbersTest_With_Prime_Numbers() throws NullArgumentException {
        Array array = new Array(23,324,4,5,-3,234,76,5);
        Integer[] expected = {23,5};
        Integer[] actual = ArrayService.findAllPrimeNumbers(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllPrimeNumbersTest_With_No_Prime_Numbers() throws NullArgumentException {
        Array array = new Array(324,4,234,76);
        Integer[] expected = {};
        Integer[] actual = ArrayService.findAllPrimeNumbers(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllFibonacciNumbersTest_With_Fibonacci_Numbers() throws NullArgumentException {
        Array array = new Array(21,324,4,5,3,-144,76,5);
        Integer[] expected = {21,5,3};
        Integer[] actual = ArrayService.findAllFibonacciNumbers(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findAllFibonacciNumbersTest_With_No_Fibonacci_Numbers() throws NullArgumentException {
        Array array = new Array(32,43,324,4,76);
        Integer[] expected = {};
        Integer[] actual = ArrayService.findAllFibonacciNumbers(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findDifferentDigitsNumbersTest_With_Different_Digits() throws NullArgumentException {
        Array array = new Array(9,565,3244,-65,231);
        Integer[] expected = {-65,231};
        Integer[] actual = ArrayService.findDifferentDigitsNumbers(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findDifferentDigitsNumbersTest_With_No_Different_Digits() throws NullArgumentException {
        Array array = new Array(9,565,3244,655);
        Integer[] expected = {};
        Integer[] actual = ArrayService.findDifferentDigitsNumbers(array);
        Assert.assertArrayEquals(expected,actual);
    }

    @Test
    public void findMaxElementTest() throws NullArgumentException, ZeroSizeException {
        Array array = new Array(9,565,3244,655);
        int expected = 3244;
        int actual = ArrayService.findMaxElement(array);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void findMinElementTest() throws NullArgumentException, ZeroSizeException {
        Array array = new Array(9,565,3244,655);
        int expected = 9;
        int actual = ArrayService.findMinElement(array);
        Assert.assertEquals(expected,actual);
    }
}
