package by.epam.xmlparser.parser.sax;


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

public class BankSAXParserTest {
    
    private BankSAXParser builder;

    @BeforeClass
    public void initBuilder() {
        builder = new BankSAXParser();
        builder.buildBanksSet("src/main/resources/banks.xml");
    }

    @Test
    public void buildBanksSetTestSize() {
        Assert.assertEquals(builder.getBanks().size(), 16);
    }

}
