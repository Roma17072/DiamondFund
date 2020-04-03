package lab.mvc;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class Gems {

    ArrayList<Gem> gems =new ArrayList<Gem>();

    public Gems(){}

    @XmlElement(name="lab.mvc.Gem")
    public ArrayList<Gem> getGems() {
        return gems;
    }

    public void addGem (Gem gem){
        gems.add(gem);
    }

    public void setGems(ArrayList<Gem> gems) {
        this.gems = gems;
    }

    @Override
    public String toString() {
        return "lab.mvc.Gems{" +
                "gems=" + gems +
                '}';
    }
}
