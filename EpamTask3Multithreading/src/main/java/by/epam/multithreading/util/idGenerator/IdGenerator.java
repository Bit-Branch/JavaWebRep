package by.epam.multithreading.util.idGenerator;

public class IdGenerator {

    private static long id = 0;

    public static long generateId(){
        return ++id;
    }

}
