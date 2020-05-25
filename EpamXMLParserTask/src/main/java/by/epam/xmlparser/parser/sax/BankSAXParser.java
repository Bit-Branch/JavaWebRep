
package by.epam.xmlparser.parser.sax;

import by.epam.xmlparser.entity.Bank;
import by.epam.xmlparser.errorHandler.BankErrorHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class BankSAXParser {
    static final Logger LOGGER = LogManager.getLogger(BankSAXParser.class);
    private Set<Bank> banks;
    private BankHandler handler;
    private XMLReader reader;
    private BankErrorHandler errorHandler;
    
    public BankSAXParser() {
        handler = new BankHandler();
        errorHandler = new BankErrorHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            LOGGER.error("SAX parser error: " + e.getMessage());
        }
    }
    
    public Set<Bank> getBanks() {
        return banks;
    }

    public void buildBanksSet(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXParseException e) {
            errorHandler.error(e);
        } catch (IOException e) {
            LOGGER.error("IO stream error: " + e);
        } catch (SAXException e) {
            e.printStackTrace();
        }
        banks = handler.getBanks();
    }
}
