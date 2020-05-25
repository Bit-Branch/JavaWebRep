package by.epam.xmlparser.entity;

public enum DepositType {
    POSTE_RESTANTE("post restante"),
    TERM("term"),
    ESTIMATED("estimated"),
    CUMULATIVE("cumulative"),
    SAVINGS("savings"),
    METAL("metal");

    private String value;

    private DepositType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static DepositType fromString(String text) {
        for (DepositType type : DepositType.values()) {
            if (type.value.equalsIgnoreCase(text)) {
                return type;
            }
        }
        return null;
    }
}
