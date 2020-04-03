package lab.sax_builder;

public enum GemEnum {
    GEMS("gems"),
    GEM("gem"),
    NAME("name"),
    ORIGIN("origin"),
    PRECIOUSNESS("preciousness"),
    VISUAL("visual"),
    CARAT("carat"),
    COLOR("color"),
    CUT("cut"),
    CLARITY("clarity");
    private String value;
    GemEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
