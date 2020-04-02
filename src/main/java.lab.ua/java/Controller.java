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




    }
}
