package by.epam.shape.util.idgenerator;

public class IdGenerator {

    private static long id = 0;

    public static long generateId(){
        return ++id;
    }

}
