package model;

public enum Role {
    ADMIN,USER;

    public static Role fromString(String string) {
        Role obj = null;

        if (string.equals("Администратор")) {
            obj = Role.ADMIN;
        } else if (string.equals("Абитуриент")) {
            obj = Role.USER;
        }
        return obj;
    }

    @Override
    public String toString() {
        String role = "Абитуриент";
        if (this == ADMIN) {
            role = "Администратор";
        }
        return role;
    }
}
