
package by.epam.xmlparser.parser.stax;


import by.epam.xmlparser.entity.Bank;
import by.epam.xmlparser.entity.BankEnum;
import by.epam.xmlparser.entity.DepositType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;


public class BankStAXParser {
    static final Logger LOGGER = LogManager.getLogger(BankStAXParser.class);
    private HashSet<Bank> banks = new HashSet<>();
    private XMLInputFactory inputFactory;

    public BankStAXParser() {
        inputFactory = XMLInputFactory.newInstance();
    }
    
    public Set<Bank> getBanks() {
        return banks;
    }
    
    public void buildBanksSet(String fileName) {
        try (FileInputStream inputStream = new FileInputStream(new File(fileName))) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);

            while (reader.hasNext()) {
               
                if (reader.next() == XMLStreamConstants.START_ELEMENT) {
                    switch (reader.getLocalName()) {
                        case "bank":
                            banks.add(buildBank(reader, new Bank()));
                            break;
                    }
                }
            }
        } catch (XMLStreamException e) {
            LOGGER.error("StAX parsing error! " + e.getMessage());
        } catch (FileNotFoundException e) {
            LOGGER.error("File " + fileName + " not found! " + e);
        } catch (IOException e) {
            LOGGER.error("Error while closing InputStream" + e);
        }
    }

    protected Bank buildBank(XMLStreamReader reader, Bank bank) throws XMLStreamException {
      
        bank.setAccountID(reader.getAttributeValue(null, BankEnum.ACCOUNT_ID.getValue()));
        if (reader.getAttributeCount() == 2) {
            bank.setDepositType(DepositType.fromString(
                    reader.getAttributeValue(null, BankEnum.DEPOSIT_TYPE.getValue())));
        }
        while (reader.hasNext()) {
            switch (reader.next()) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (BankEnum.fromString(name)) {
                        case NAME:
                            bank.setName(getXMLText(reader));
                            break;

                        case COUNTRY:
                            bank.setCountry(getXMLText(reader));
                            break;

                        case DEPOSITOR:
                            bank.setDepositor(getXMLText(reader));
                            break;

                        case ACCOUNT_ON_DEPOSIT:
                            bank.setAccountOnDeposit(BigDecimal.valueOf(Double.parseDouble(getXMLText(reader))));
                            break;

                        case PROFITABILITY:
                            bank.setProfitability(Double.parseDouble(getXMLText(reader)));
                            break;

                        case TIME_CONSTRAINTS: {
                            Calendar cal = Calendar.getInstance();
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss", Locale.ENGLISH);
                            try {
                                cal.setTime(sdf.parse(getXMLText(reader)));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            bank.setTimeConstraints(cal);
                            break;
                        }
                    default:
                        break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (BankEnum.fromString(reader.getLocalName()) == BankEnum.BANK) {
                        return bank;
                    }
            }
        }
        throw new XMLStreamException("Unknown element");
    }
    
    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }   
}
