package lab.mvc;

public class DiamondFund {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
        controller.process();
    }
}
