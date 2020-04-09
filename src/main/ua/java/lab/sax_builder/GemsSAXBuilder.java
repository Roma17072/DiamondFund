package lab.sax_builder;

import lab.mvc.Command;
import lab.mvc.Gem;
import lab.mvc.GlobalConst;
import lab.mvc.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

public class GemsSAXBuilder extends DefaultHandler implements Command {

    public ArrayList<Gem> gemsSAXBuilder(String filename) {
        Logger logger = LogManager.getLogger("ua.java.lab");
        SAXParserFactory factory = SAXParserFactory.newInstance();
        factory.setNamespaceAware(true);
        GemsHandler gemsHandler = new GemsHandler();
        ArrayList<Gem> gems = new ArrayList<>();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(new File(filename), gemsHandler);
            gems = new ArrayList<>(gemsHandler.getGems());
        } catch (ParserConfigurationException e) {
            logger.error(filename + " config error: " + e.getMessage());
        } catch (SAXException e) {
            logger.error(filename + " SAX error: " + e.getMessage());
        } catch (IOException e) {
            logger.error("I/O error: " + e.getMessage());
        }

        gems.sort((Gem o1 , Gem o2)->Integer.compare(o2.getCarat(), o1.getCarat()));
        return gems;
    }

    @Override
    public void execute() {
        View.printMessage(View.BUILD_GEM);
        View.printResult(gemsSAXBuilder(GlobalConst.FILENAME));
    }
}
