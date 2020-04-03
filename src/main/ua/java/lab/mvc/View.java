package lab.mvc;

import java.util.ArrayList;


public class View {
    public static final String CHECK_VALID = "Checking  XML file \"lab.mvc.Gems.xml\" on valid using XSD \"lab.mvc.Gems.xsd\" ";
    public static final String BUILD_GEM = "Parse XML file \"lab.mvc.Gems.xml\" and build gems collection ";
    public static final String TRANSFORM_XML = "Transform XML file \"lab.mvc.Gems.xml\" to New gem.xml using \"lab.mvc.Gems.xsl\" and change root element to origin ";
    public static final String VALID = "File is valid";
    public static final String TRANSFORM_COMPLETE = "Transform complete";
    public static final String TRANSFORM_FAIL= "Impossible transform file";
    public static final String NOT_VALID = "File is not valid";
    public static final String CREATE_SUCCESS = "File XML create success";
    public static final String CREATE_FAIL = "File XML can't create";
    public static final String MARSHALL = "Start marshall Gems collection";
    public static final String UNMARSHAL = "Start unmarshal New_gems.xml to Gems collection";
    public static final String UNMARSHAL_SUCCESS = "Unmarshal success";
    public static final String UNMARSHAL_FAIL = "Unmarshal can't create";

    public void printMessage(String message){
        System.out.println(message);
    }
    public void printResult (ArrayList<Gem> gems) {
        for (Gem i : gems) {
            System.out.println(i);
        }
    }
}
