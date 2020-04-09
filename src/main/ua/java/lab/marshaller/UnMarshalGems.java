package lab.marshaller;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

import lab.mvc.Command;
import lab.mvc.Gems;
import lab.mvc.GlobalConst;
import lab.mvc.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UnMarshalGems implements Command {
    public boolean unmarshal(String file) {
        Logger logger = LogManager.getLogger("ua.java.lab");
        View view =new View();
        try {
            JAXBContext jc = JAXBContext.newInstance(Gems.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(file);
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

    @Override
    public void execute() {
        View.printMessage(View.UNMARSHAL);
        if (unmarshal(GlobalConst.GEM_MARSH)){
            View.printMessage(View.UNMARSHAL_SUCCESS);
        }else {
            View.printMessage(View.UNMARSHAL_FAIL);
        }
    }
}
