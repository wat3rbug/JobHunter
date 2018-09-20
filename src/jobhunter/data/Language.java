package jobhunter.data;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Douglas Gardiner
 */
public class Language {

    private static int lastId = 1;

    private final int id;
    public String language;
    
    public Language(String loc) {
            this.language = loc;
            this.id = lastId++;
    }
    
    @Override
    public String toString() {
        return language;
    }
    
    public static ArrayList<Language> getByXMLElement(Element el) {
        if (el == null) return null;
        ArrayList<Language> langs = new ArrayList<Language>();
        NodeList list = el.getElementsByTagName("language");
        for (int i = 0; i < list.getLength(); i++) {
            String lang = list.item(i).getTextContent();
            langs.add(new Language(lang));
        }
        return langs;
    }
}
