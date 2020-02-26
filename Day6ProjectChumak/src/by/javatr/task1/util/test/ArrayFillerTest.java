package by.javatr.task1.util.test;

import by.javatr.task1.entity.Array;
import by.javatr.task1.exception.IncorrectFileContentException;
import by.javatr.task1.exception.NegativeSizeException;
import by.javatr.exception.NullArgumentException;
import by.javatr.task1.util.ArrayFiller;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.NoSuchFileException;

public class ArrayFillerTest {

    @Test(expected = NegativeSizeException.class)
    public void fillArrayWithRandomNumbersTest_With_Negative_Size()
            throws NegativeSizeException, NullArgumentException {
        int size = -2;
        ArrayFiller.fillArrayWithRandomNumbers(size);
    }

    @Test
    public void fillArrayWithRandomNumbersTest_With_Zero_Size()
            throws NegativeSizeException, NullArgumentException {
        int size = 0;
        Array expected = new Array();
        Array actual = ArrayFiller.fillArrayWithRandomNumbers(size);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void fillArrayFromFileTest_With_Valid_File() throws NoSuchFileException,
            IncorrectFileContentException, NullArgumentException {
        File file = new File("src/by/javatr/task1/resource/validArrayFile.txt");
        Array expected = new Array(1,5,3,6,7,4,5);
        Array actual = ArrayFiller.fillArrayFromFile(file);
        Assert.assertEquals(expected,actual);
    }

    @Test(expected = IncorrectFileContentException.class)
    public void fillArrayFromFileTest_With_Invalid_File() throws NoSuchFileException,
            IncorrectFileContentException, NullArgumentException {
        File file = new File("src/by/javatr/task1/resource/invalidArrayFile.txt");
        ArrayFiller.fillArrayFromFile(file);
    }

    @Test(expected = NoSuchFileException.class)
    public void fillArrayFromFileTest_With_Null_File() throws NoSuchFileException,
            IncorrectFileContentException, NullArgumentException {
        File file = null;
        ArrayFiller.fillArrayFromFile(file);
    }
}
