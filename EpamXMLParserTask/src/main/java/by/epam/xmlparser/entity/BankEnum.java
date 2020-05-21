package by.epam.xmlparser.entity;

public enum BankEnum {

    BANKS("banks"),
    BANK("bank"),
    ACCOUNT_ID("accountID"),
    DEPOSIT_TYPE("depositType"),
    NAME("name"),
    COUNTRY("country"),
    DEPOSITOR("depositor"),
    ACCOUNT_ON_DEPOSIT("accountOnDeposit"),
    PROFITABILITY("profitability"),
    TIME_CONSTRAINTS("timeConstraints");
    
    private String value;
    
    private BankEnum(String value) {
        this.value = value;
    }
    
    public String getValue() {
        return value;
    }
    
}
