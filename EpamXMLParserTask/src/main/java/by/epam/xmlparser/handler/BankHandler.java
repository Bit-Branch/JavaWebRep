
package by.epam.xmlparser.handler;

import by.epam.xmlparser.entity.Bank;
import by.epam.xmlparser.entity.BankEnum;
import by.epam.xmlparser.entity.DepositType;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class BankHandler extends DefaultHandler {

    static final int ACCOUNT_ID_ATTR = 0;
    static final int DEPOSIT_TYPE_ATTR = 1;
    private Set<Bank> banks;
    private Bank current;
    private BankEnum currentEnum;

    public BankHandler() {
        banks = new HashSet<>();
    }

    public Set<Bank> getBanks() {
        return Collections.unmodifiableSet(banks);
    }
    
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (BankEnum.BANK.getValue().equals(localName)) {
            current = new Bank();
            current.setAccountID(attrs.getValue(ACCOUNT_ID_ATTR).intern());

            if (attrs.getLength() == 2) {
                current.setDepositType(DepositType.valueOf(attrs.getValue(DEPOSIT_TYPE_ATTR)));
            }
        }
    }
    
    public void endElement(String uri, String localName, String qName) {
        if (BankEnum.BANK.getValue().equals(localName)) {
            banks.add(current);
        }
    }
    
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim().intern();
        if (currentEnum != null) {
            switch (currentEnum) {
                case NAME:
                    current.setName(s);
                    break;

                case COUNTRY:
                    current.setCountry(s);
                    break;

                case DEPOSITOR:
                    current.setDepositor(s);
                    break;

                case ACCOUNT_ON_DEPOSIT:
                    current.setAccountOnDeposit(BigDecimal.valueOf(Long.parseLong(s)));
                    break;

                case PROFITABILITY:
                    current.setProfitability(Double.parseDouble(s));
                    break;

                case TIME_CONSTRAINTS: {
                    Calendar cal = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss", Locale.ENGLISH);
                    try {
                        cal.setTime(sdf.parse(s));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    current.setTimeConstraints(cal);
                    break;
                }
                default:
                    throw new EnumConstantNotPresentException(
                            currentEnum.getDeclaringClass(), currentEnum.name());
            }
        }
        currentEnum = null;
    }
}   
