
package by.epam.xmlparser.parser;

import by.epam.xmlparser.entity.Bank;
import by.epam.xmlparser.handler.BankHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;


public class BanksSAXParser {
    static final Logger logger = LogManager.getLogger(BanksSAXParser.class);
    private Set<Bank> banks;
    private BankHandler handler;
    private XMLReader reader;
    
    public BanksSAXParser() {
        handler = new BankHandler();
        
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(handler);
        } catch (SAXException e) {
            logger.error("SAX parser error: " + e.getMessage());
        }
    }
    
    public Set<Bank> getBanks() {
        return banks;
    }

    public void createBanksSet(String fileName) {
        try {
            reader.parse(fileName);
        } catch (SAXException e) {
            logger.error("SAX parser error: " + e);
        } catch (IOException e) {
            logger.error("IO stream error: " + e);
        }
        banks = handler.getBanks();
    }
}
