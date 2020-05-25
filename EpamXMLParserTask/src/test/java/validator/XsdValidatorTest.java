package validator;

import by.epam.xmlparser.validator.XsdValidator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class XsdValidatorTest {

    private XsdValidator validator;
    private String xmlFilePath;
    private String xsdFilePath;

    @BeforeClass
    public void setUp(){
        validator = new XsdValidator();
        xmlFilePath = "src/main/resources/banks.xml";
        xsdFilePath = "src/main/resources/banks.xsd";
    }

    @Test
    public void validateXMLFileTest(){
        boolean actual = validator.validate(xmlFilePath, xsdFilePath);
        Assert.assertTrue(actual);
    }
}