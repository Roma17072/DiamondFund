import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransform {

    public static boolean XSLTransform(String filename) {
         Logger logger = LogManager.getLogger("java.lab.ua");
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource("Gems.xsl"));
            transformer.transform(new StreamSource(filename),
                    new StreamResult("New_gems.xml"));
            return true;
        } catch(TransformerException e) {
            logger.error("Impossible transform file " + filename + " : " + e);
            return false;
        }
    }
}

