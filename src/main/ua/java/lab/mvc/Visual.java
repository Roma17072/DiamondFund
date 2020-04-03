package lab.mvc;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"color", "clarity" , "cut"})
public class Visual{
    private String color;
    private float clarity;
    private int cut;

    public Visual() {
    }

    public Visual(String color, float clarity, int cut) {
        this.color = color;
        this.clarity = clarity;
        this.cut = cut;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setClarity(float clarity) {
        this.clarity = clarity;
    }

    public void setCut(int cut) {
        this.cut = cut;
    }

    public String getColor() {
        return color;
    }

    public float getClarity() {
        return clarity;
    }

    public int getCut() {
        return cut;
    }

    @Override
    public String toString() {
        return "lab.mvc.Visual{" +
                "color='" + color + '\'' +
                ", clarity=" + clarity +
                ", cut=" + cut +
                '}';
    }

}
