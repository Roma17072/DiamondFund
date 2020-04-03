package lab.mvc;

import lab.marshaller.MarshallGems;
import lab.marshaller.UnMarshalGems;
import lab.sax_builder.GemsSAXBuilder;
import lab.sax_validator.ValidatorSAX;
import lab.xsl_transform.XSLTransform;

public class Controller {
View view;
Model model;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    public void process(){
        view.printMessage(View.CHECK_VALID);
        if(ValidatorSAX.validate(model.getFilename(), model.getSchemaname())) {
            view.printMessage(View.VALID);
        }else {
            view.printMessage(View.NOT_VALID);
        }
        view.printMessage(View.BUILD_GEM);
        view.printResult(GemsSAXBuilder.gemsSAXBuilder(model.getFilename()));
        view.printMessage(View.TRANSFORM_XML);
        if(XSLTransform.XSLTransform(model.getFilename())) {
            view.printMessage(View.TRANSFORM_COMPLETE);
        }else {
            view.printMessage(View.TRANSFORM_FAIL);
        }
        view.printMessage(View.MARSHALL);
        if(MarshallGems.marshal()){
            view.printMessage(View.CREATE_SUCCESS);
        }else {
            view.printMessage(View.CREATE_FAIL);
        }
        view.printMessage(View.UNMARSHAL);
        if (UnMarshalGems.unmarshal()){
            view.printMessage(View.UNMARSHAL_SUCCESS);
        }else {
            view.printMessage(View.UNMARSHAL_FAIL);
        }
    }
}
