package lab.xsl_transform;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransform {

    public static boolean XSLTransform(String filename) {
         Logger logger = LogManager.getLogger("ua.java.lab");
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource("src/main/ua/java/lab/xsl_transform/Gems.xsl"));
            transformer.transform(new StreamSource(filename),
                    new StreamResult("src/main/ua/java/lab/sax_builder/New_gems.xml"));
            return true;
        } catch(TransformerException e) {
            logger.error("Impossible transform file " + filename + " : " + e);
            return false;
        }
    }
}

