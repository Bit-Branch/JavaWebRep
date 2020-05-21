
package by.epam.xmlparser.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;


public class XsdValidator {

    static final Logger logger = LogManager.getLogger(XsdValidator.class);
    private SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    
    public boolean validate(String fileName, String schemaName) {
        File schemaLoc = new File(schemaName);
        
        try {
            Schema schema = factory.newSchema(schemaLoc);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(fileName));
            return true;
        } catch (SAXException e) {
            logger.error("Not valid: " + e.getMessage());
            return false;
        } catch (IOException e) {
            logger.error("Not valid: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            logger.error("Cannot validate: " + e.getMessage());
            return false;
        }
    }
}
