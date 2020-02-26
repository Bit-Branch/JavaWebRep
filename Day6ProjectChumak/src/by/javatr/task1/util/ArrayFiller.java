package by.javatr.task1.util;

import by.javatr.task1.entity.Array;
import by.javatr.task1.exception.IncorrectFileContentException;
import by.javatr.task1.exception.NegativeSizeException;
import by.javatr.exception.NullArgumentException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Random;

public class ArrayFiller {

    public static Array fillArrayFromFile(File file) throws NoSuchFileException,
            IncorrectFileContentException, NullArgumentException {
        Array numbers = new Array();
        if (file == null) {
            throw new NoSuchFileException("There is no file");
        }

        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            String[] numbersStrings = line.split(",");
            for (String numbersString : numbersStrings) {
                numbers.add(Integer.parseInt(numbersString));
            }
        } catch (IOException e) {
            throw new IncorrectFileContentException("File contains incorrect info: "
                    + file.getAbsolutePath());
        }
        return numbers;
    }

    public static Array fillArrayWithRandomNumbers(int size) throws NegativeSizeException,
            NullArgumentException {
        if (size < 0){
            throw new NegativeSizeException("size is negative");
        }
        Array array = new Array();
        Random rand = new Random();
        for(int i = 0; i < size; i++){
            array.add(rand.nextInt());
        }
        return array;
    }
}
