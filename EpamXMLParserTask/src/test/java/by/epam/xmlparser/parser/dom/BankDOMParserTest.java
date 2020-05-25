package by.epam.xmlparser.parser.dom;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BankDOMParserTest {

    private BankDOMParser builder;

    @BeforeClass
    public void initBuilder() {
        builder = new BankDOMParser();
        builder.buildBanksSet("src/main/resources/banks.xml");
    }
    @Test
    public void buildBanksSetTestSize() {
        Assert.assertEquals(builder.getBanks().size(), 16);
    }

}