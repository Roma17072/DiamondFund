package lab.marshaller;

import lab.mvc.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;



public class MarshallGems implements Command {
    public boolean marshal () {
        Logger logger = LogManager.getLogger("ua.java.lab");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Gems.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            Gems gems = new Gems() {
                {
                    Visual v = new Visual("red",67.5f,6);
                    Gem g = new Gem("Rubin","Australia","semiprecious",v,20 );
                    this.addGem(g);

                    v = new Visual("white",45.7f,4);
                    g = new Gem("Diamond","Canada","precious",v,10 );
                    this.addGem(g);

                    v = new Visual("bluish white",87.0f,6);
                    g = new Gem("Diamond","Australia","precious",v,12 );
                    this.addGem(g);
                }
            };
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(gems, new FileOutputStream(GlobalConst.GEM_MARSH));
            jaxbMarshaller.marshal(gems, System.out);
            return true;
        } catch (FileNotFoundException e) {
            logger.error("XML-fail can't be created: " + e);
            return false;
        } catch (JAXBException e) {
            logger.error("JAXB-error " + e);
            return false;
        }
    }

    @Override
    public void execute() {
        View.printMessage(View.MARSHALL);
        if(marshal()){
            View.printMessage(View.CREATE_SUCCESS);
        }else {
            View.printMessage(View.CREATE_FAIL);
        }
    }
}
