package jobhunter.data;

import java.util.ArrayList;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * @author Douglas Gardiner
 * Basic data object that stores language information.
 */

public class Language {

    private static int lastId = 1;

    private final int id;
    public String language;
    
    public Language(String loc) {
            this.language = loc;
            this.id = lastId++;
    }
    
    /**
     * Overrides the standard toString() method so that display information is
     * given in the job listing panel of the application.
     * @return a String with the language.
     */
    
    @Override
    public String toString() {
        return language;
    }
    
    /**
     * Converts an XML Element to an array of Language objects.  This is used 
     * for reading an XML file to get all the relevant details for the Language
     * objects.
     * @param el
     * @return an ArrayList of Language objects with all the details for the 
     * languages.
     */
    
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
