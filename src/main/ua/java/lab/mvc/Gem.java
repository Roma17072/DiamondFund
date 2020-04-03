package lab.mvc;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "lab.mvc.Gem")
@XmlType(propOrder={"name", "origin" , "preciousness", "visual", "carat"})
public class Gem {
    @XmlAttribute
    private String name;
    @XmlElement
    private String origin;
    @XmlElement
    private String preciousness;
    @XmlElement
    private Visual visual;

    private int carat;

    public Gem() {
    }

    public Gem(String name, String origin, String preciousness, Visual visual, int carat) {
        this.name = name;
        this.origin = origin;
        this.preciousness = preciousness;
        this.visual = visual;
        this.carat = carat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }

    public void setCarat(int carat) {
        this.carat = carat;
    }
    @XmlElement
    public int getCarat() {
        return carat;
   }

    @Override
    public String toString() {
        return "lab.mvc.Gem{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", visual=" + visual +
                ", carat=" + carat +
                '}';
    }

}

