package by.javatr.task1.entity.test;

import by.javatr.task1.entity.GenericArray;
import by.javatr.exception.NullArgumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GenericArrayTest {
    private GenericArray<Man> genericArray;

    @Before
    public void setUp(){
        genericArray = new GenericArray<>(new Man(12,"John"),
                new Man(11,"Linda"), new Man(8,"Jake"));
    }

    @Test
    public void addTest() throws NullArgumentException {
        GenericArray<Man> expected = new GenericArray<>(new Man(12,"John"),
                new Man(11,"Linda"), new Man(8,"Jake"),
                new Man(10,"Make"));
        genericArray.add(new Man(10,"Make"));
        Assert.assertEquals(expected,genericArray);
    }

    @Test
    public void getTest(){
        Man expected = new Man(11,"Linda");
        Man actual = genericArray.get(1);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void doSelectionSortTest(){
        GenericArray<Man> expected = new GenericArray<>(new Man(8,"Jake"),
                new Man(11,"Linda"), new Man(12,"John") );
        genericArray.doSelectionSort();
        Assert.assertEquals(expected,genericArray);
    }

    @Test
    public void doInsertionSortTest(){
        GenericArray<Man> expected = new GenericArray<>(new Man(8,"Jake"),
                new Man(11,"Linda"), new Man(12,"John") );
        genericArray.doInsertionSort();
        Assert.assertEquals(expected,genericArray);
    }

    @Test
    public void doBubbleSortTest(){
        GenericArray<Man> expected = new GenericArray<>(new Man(8,"Jake"),
                new Man(11,"Linda"), new Man(12,"John") );
        genericArray.doBubbleSort();
        Assert.assertEquals(expected,genericArray);
    }

    @Test
    public void findIndexOfTest() throws NullArgumentException {
        int expected = 0;
        int actual = genericArray.findIndexOf(new Man(8,"Jake"));
        Assert.assertEquals(expected,actual);
    }
}
