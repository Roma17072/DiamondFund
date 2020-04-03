package lab.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;
import lab.mvc.Gems;
import lab.mvc.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnMarshalGems {
    public static boolean unmarshal() {
        Logger logger = LogManager.getLogger("ua.java.lab");
        View view =new View();
        try {
            JAXBContext jc = JAXBContext.newInstance(Gems.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("Gems_marsh.xml");
            Gems gems = (Gems) u.unmarshal(reader);
            view.printResult(gems.getGems());
            return true;
        } catch (JAXBException e) {
            logger.error("JAXB-error " + e);
            return false;
        } catch (FileNotFoundException e) {
            logger.error("XML-file not found " + e);
            return false;
        }
    }
}
