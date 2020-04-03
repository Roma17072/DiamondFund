package lab.sax_builder;

import lab.mvc.Gem;
import lab.mvc.Visual;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.EnumSet;

public class GemsHandler extends DefaultHandler {
    private ArrayList<Gem> gems;
    private Gem current = null;
    private Visual visual = null;
    private GemEnum currentEnum = null;
    private EnumSet<GemEnum> withText;

    public GemsHandler() {
        gems = new ArrayList<Gem>();
        withText = EnumSet.range(GemEnum.GEM, GemEnum.CLARITY);
    }

    public ArrayList<Gem> getGems() {
        return gems;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        if ("gem".equals(localName)) {
            current = new Gem();
            visual = new Visual();
            current.setName(attributes.getValue("name"));
        } else {
            GemEnum temp = GemEnum.valueOf(localName.toUpperCase());
            if (withText.contains(temp)) {
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        current.setVisual(visual);
        if (visual.getColor() != null && visual.getClarity() != 0 && visual.getCut() != 0) {
            current.setVisual(visual);
        }
        if ("gem".equals(localName)) {
            gems.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s = new String(ch, start, length).trim();
        if (currentEnum != null) {
            switch (currentEnum) {
                case ORIGIN:
                    current.setOrigin(s);
                    break;
                case PRECIOUSNESS:
                    current.setPreciousness(s);
                    break;
                case COLOR:
                    visual.setColor(s);
                    break;
                case CLARITY:
                    visual.setClarity(Float.parseFloat(s));
                    break;
                case CUT:
                    visual.setCut(Integer.parseInt(s));
                    break;
                case VISUAL:
                    break;
                case CARAT:
                    current.setCarat(Integer.parseInt(s));
                    break;
            }
        }
        currentEnum = null;
    }
}

