
package by.epam.xmlparser.parser;
import by.epam.xmlparser.entity.Bank;
import by.epam.xmlparser.entity.DepositType;
import by.epam.xmlparser.exception.ElementNotPresentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


public class BanksDOMParser {
    static final Logger logger = LogManager.getLogger(BanksDOMParser.class);
    private Set<Bank> banks;
    private DocumentBuilder docBuilder;
    
    public BanksDOMParser() {
        banks = new HashSet<Bank>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            logger.error("Parser configuration exception: " + e);
        }
    }
    
    public Set<Bank> getBanks() {
        return banks;
    }
    
    public void createBanksSet(String fileName) {
        try {
            Document doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            buildSetByTagName("bank", root);
        } catch (IOException e) {
            logger.error("File error or I/O error: " + e);
        } catch (SAXException e) {
            logger.error("Parsing failure: " + e);
        } catch (IllegalArgumentException e) {
            logger.error("uri is null" + e);
        }
    }
    
    protected Bank createBank(Element periodicalElement) throws ElementNotPresentException {
        Bank bank;
        switch (periodicalElement.getTagName()) {
            case "bank":
                bank = new Bank();
                break;
            default:
               throw new ElementNotPresentException();
        }
        
        bank.setAccountID(periodicalElement.getAttribute("accountID"));
        if (periodicalElement.hasAttribute("depositType")) {
            bank.setDepositType(DepositType.valueOf(
                    periodicalElement.getAttribute("depositType")));
        }
        bank.setName(getElementTextContent(periodicalElement, "name"));
        bank.setCountry(getElementTextContent(periodicalElement, "country"));
        bank.setDepositor(getElementTextContent(periodicalElement, "depositor"));
        bank.setAccountOnDeposit(BigDecimal.valueOf(Long.parseLong(getElementTextContent(periodicalElement, "accountOnDeposit"))));
        bank.setProfitability(Double.parseDouble(getElementTextContent(periodicalElement, "profitability")));
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss", Locale.ENGLISH);
            try {
                cal.setTime(sdf.parse(getElementTextContent(periodicalElement, "timeConstraints")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        bank.setTimeConstraints(cal);

        
        return bank;
    }
    
    private void buildSetByTagName(String tagName, Element root) {
        logger.debug((root.getElementsByTagName(tagName)).getLength());
        NodeList periodicalsList = root.getElementsByTagName(tagName);
        for (int i = 0; i < periodicalsList.getLength(); i++) {
            Element bankElement = (Element) periodicalsList.item(i);
            Bank bank = null;
            try {
                bank = createBank(bankElement);
                banks.add(bank);
            } catch (ElementNotPresentException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
