package lab.xsl_transform;

import lab.mvc.Command;
import lab.mvc.GlobalConst;
import lab.mvc.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTransform implements Command {

    public boolean XSLTransform(String filename) {
         Logger logger = LogManager.getLogger("ua.java.lab");
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(GlobalConst.FILE_XSL));
            transformer.transform(new StreamSource(filename),
                    new StreamResult(GlobalConst.NEW_FILE_XML));
            return true;
        } catch(TransformerException e) {
            logger.error("Impossible transform file " + filename + " : " + e);
            return false;
        }
    }

    @Override
    public void execute() {
        View.printMessage(View.TRANSFORM_XML);
        if(XSLTransform(GlobalConst.FILENAME)) {
            View.printMessage(View.TRANSFORM_COMPLETE);
        }else {
            View.printMessage(View.TRANSFORM_FAIL);
        }
    }
}

