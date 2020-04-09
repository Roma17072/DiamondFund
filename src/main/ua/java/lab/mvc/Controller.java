package lab.mvc;

import lab.marshaller.MarshallGems;
import lab.marshaller.UnMarshalGems;
import lab.sax_builder.GemsSAXBuilder;
import lab.sax_validator.ValidatorSAX;
import lab.xsl_transform.XSLTransform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    Model model;
    Logger logger = LogManager.getLogger("ua.java.lab");
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Controller(Model model) {
        this.model = model;
        setCommands();
    }

    public void process(){
        View.printMessage(View.MENU);
        model.start(check(br));
        process();
    }

    public void setCommands(){
        model.setCommand(new ValidatorSAX());
        model.setCommand(new GemsSAXBuilder());
        model.setCommand(new XSLTransform());
        model.setCommand(new MarshallGems());
        model.setCommand(new UnMarshalGems());
    }
    public int check(BufferedReader br) {
        int value = 0;
        do {
            try {
                value = Integer.parseInt(br.readLine());
                if (value > 5 || value < 0){
                    logger.info("Input value more on less then limit",value);
                    value = 0;
                    View.printMessage(View.WRONG);
                }
            } catch (NumberFormatException | IOException e) {
                View.printMessage(View.WRONG);
                logger.error("Wrong input format ",e);
            }
        }while (value == 0);
        return value;
    }

}
