package by.epam.xmlparser.entity;

import java.math.BigDecimal;
import java.util.Calendar;

public class Bank {

    private String accountID;
    private DepositType depositType;
    private String name;
    private String country;
    private String depositor;
    private BigDecimal accountOnDeposit;
    private double profitability;
    private Calendar timeConstraints;

    public Bank() {
    }

    public Bank(String accountID, DepositType depositType, String name, String country, String depositor,
                BigDecimal accountOnDeposit, double profitability, Calendar timeConstraints) {
        this.accountID = accountID;
        this.depositType = depositType;
        this.name = name;
        this.country = country;
        this.depositor = depositor;
        this.accountOnDeposit = accountOnDeposit;
        this.profitability = profitability;
        this.timeConstraints = timeConstraints;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public DepositType getDepositType() {
        return depositType;
    }

    public void setDepositType(DepositType depositType) {
        this.depositType = depositType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public BigDecimal getAccountOnDeposit() {
        return accountOnDeposit;
    }

    public void setAccountOnDeposit(BigDecimal accountOnDeposit) {
        this.accountOnDeposit = accountOnDeposit;
    }

    public double getProfitability() {
        return profitability;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public Calendar getTimeConstraints() {
        return timeConstraints;
    }

    public void setTimeConstraints(Calendar timeConstraints) {
        this.timeConstraints = timeConstraints;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        return timeConstraints != null ? timeConstraints.equals(bank.timeConstraints) : bank.timeConstraints == null &&
                bank.profitability == profitability &&
                accountID != null ? accountID.equals(bank.accountID) : bank.accountID == null &&
                depositType == bank.depositType &&
                name != null ? name.equals(bank.name) : bank.name == null &&
                country != null ? country.equals(bank.country) : bank.country == null &&
                depositor != null ? depositor.equals(bank.depositor) : bank.depositor == null &&
                accountOnDeposit != null ? accountOnDeposit.equals(bank.accountOnDeposit) : bank.accountOnDeposit == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = accountID != null ? accountID.hashCode() : 0;
        result = 31 * result + (depositType != null ? depositType.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (depositor != null ? depositor.hashCode() : 0);
        result = 31 * result + (accountOnDeposit != null ? accountOnDeposit.hashCode() : 0);
        temp = Double.doubleToLongBits(profitability);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (timeConstraints != null ? timeConstraints.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return getName().getClass() +
                "accountID='" + accountID + '\'' +
                ", depositType=" + depositType +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", depositor='" + depositor + '\'' +
                ", accountOnDeposit=" + accountOnDeposit +
                ", profitability=" + profitability +
                ", timeConstraints=" + timeConstraints;
    }
}
