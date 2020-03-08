package by.javatr.task1.entity;

import java.util.HashMap;
import java.util.Map;

public enum Color {
    BLACK(1),
    WHITE(2),
    RED(3),
    YELLOW(4),
    GREEN(5),
    BLUE(6);

    private static Map<Integer, Color> colors = new HashMap<>();
    private int value;

    Color(int value) {
        this.value = value;
    }

    static {
        for (Color color : Color.values()) {
            colors.put(color.value, color);
        }
    }

    public static Color valueOf(int colorNumber) {
        return colors.get(colorNumber);
    }

    public int getValue() {
        return value;
    }
}
