
public class Gem {
    private String name;
    private String origin;
    private String preciousness;
    private Visual visual;
    private int carat;


    public Gem() {
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

    public int getCarat() {
        return carat;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", preciousness='" + preciousness + '\'' +
                ", visual=" + visual +
                ", carat=" + carat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Gem gem = (Gem) o;

        if (getCarat() != gem.getCarat()) return false;
        if (!name.equals(gem.name)) return false;
        if (!origin.equals(gem.origin)) return false;
        if (!preciousness.equals(gem.preciousness)) return false;
        return visual.equals(gem.visual);
    }

}
class Visual{
    private String color;
    private float clarity;
    private int cut;

    public Visual() {
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
        return "Visual{" +
                "color='" + color + '\'' +
                ", clarity=" + clarity +
                ", cut=" + cut +
                '}';
    }

}

