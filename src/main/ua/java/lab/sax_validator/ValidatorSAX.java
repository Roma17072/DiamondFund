package lab.sax_validator;

import lab.mvc.Command;
import lab.mvc.GlobalConst;
import lab.mvc.View;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;


public class ValidatorSAX implements Command {
    View view = new View();
    public boolean validate(String filename, String schemaname) {
        Schema schema = null;
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            schema = factory.newSchema(new File(schemaname));
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(filename, new GemsErrorHandler());
            return true;
        } catch (ParserConfigurationException e) {
            System.err.println(filename + " config error: " + e.getMessage());
            return false;
        } catch (SAXException e) {
            System.err.println(filename + " SAX error: " + e.getMessage());
            return false;
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void execute() {
        if(validate(GlobalConst.FILENAME,GlobalConst.SCHEMA_NAME)) {
            View.printMessage(View.CHECK_VALID);
            view.printMessage(View.VALID);
        }else {
            view.printMessage(View.NOT_VALID);
        }
    }

}

