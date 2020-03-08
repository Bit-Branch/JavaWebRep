package by.javatr.task1.scanner;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DataScanner {
    private static final Scanner scanner = new Scanner(System.in);

    public static double enterDouble() throws InputMismatchException {
        while(!scanner.hasNextDouble()){
            scanner.next();
        }
        return scanner.nextDouble();
    }

    public static int enterInt() throws InputMismatchException {
        while(!scanner.hasNextInt()){
            scanner.next();
        }
        return scanner.nextInt();
    }
}
