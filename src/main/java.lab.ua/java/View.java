import java.util.ArrayList;

public class View {
    public static final String CHECK_VALID = "Checking  XML file \"Gems.xml\" on valid using XSD \"Gems.xsd\" ";
    public static final String BUILD_GEM = "Parse XML file \"Gems.xml\" and build gems collection ";
    public static final String TRANSFORM_XML = "Transform XML file \"Gems.xml\" to New gem.xml using \"Gems.xsl\" and change root element to origin ";
    public static final String VALID = "File is valid";
    public static final String TRANSFORM_COMPLETE = "Transform complete";
    public static final String TRANSFORM_FAIL= "Impossible transform file";
    public static final String NOT_VALID = "File is not valid";

    public void printMessage(String message){
        System.out.println(message);
    }
    public void printResult (ArrayList<Gem> gems) {
        for (Gem i : gems) {
            System.out.println(i);
        }
    }
}
