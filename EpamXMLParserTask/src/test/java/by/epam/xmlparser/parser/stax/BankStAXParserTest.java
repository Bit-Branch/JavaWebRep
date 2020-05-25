package by.epam.xmlparser.parser.stax;

import by.epam.xmlparser.entity.Bank;
import by.epam.xmlparser.entity.DepositType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class BankStAXParserTest {

    private BankStAXParser builder;

    @BeforeClass
    public void initBuilder() {
        builder = new BankStAXParser();
        builder.buildBanksSet("src/main/resources/banks.xml");
    }

    @Test
    public void buildBanksSetTestSize() {
        Assert.assertEquals(builder.getBanks().size(),16);
    }

    @Test
    public void buildBanksSetTestElementBank() {
        Bank bank = new Bank();
        bank.setAccountID("c5565-3657-3685-8976");
        bank.setDepositType(DepositType.ESTIMATED);
        bank.setName("Union Bank of India");
        bank.setCountry("India");
        bank.setDepositor("Imol D.E.");
        bank.setAccountOnDeposit(BigDecimal.valueOf(90000.0));
        bank.setProfitability(15);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss", Locale.ENGLISH);
        try {
            cal.setTime(sdf.parse("2020-11-22T10:36:28"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        bank.setTimeConstraints(cal);

        Assert.assertTrue(builder.getBanks().contains(bank));
    }
}
