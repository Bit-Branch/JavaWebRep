package by.epam.committiee.servlet;

import javax.servlet.ServletContext;
import java.io.*;

public class Testda {



    public static void main(String[] args) {
        File directory = new File("src/main/resources/database/images/avatar 4.png");
        System.out.println(directory.getAbsolutePath());
        File file = new File("src/main/resources/database/images/avatar 4.png");
        System.out.println(file.exists());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            System.out.println(fileOutputStream.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
