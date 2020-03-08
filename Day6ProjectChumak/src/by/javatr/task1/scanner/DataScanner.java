package by.javatr.task1.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {

    private static final Scanner scanner = new Scanner(System.in);

    public static int enterInt() throws InputMismatchException {
        while(!scanner.hasNextInt()){
            scanner.next();
        }
        return scanner.nextInt();
    }

    public static int[] enterIntArray(int size) throws InputMismatchException {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = enterInt();
        }
        return array;
    }

}
