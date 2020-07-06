package by.epam.tagtask.tag;

public class NotNullFunction {
    public static String notNull(Object ob) {
        String res = null;
        if (ob == null || ob.toString().isEmpty()) {
            res = "Attribute or Parameter is null or empty";
        } else {
            res = ob.toString();
        }
        return res;
    }
}