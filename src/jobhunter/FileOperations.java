package jobhunter;

import java.io.File;
import java.util.ArrayList;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import jobhunter.data.Job;

/**
 * @author Douglas Gardiner
 */
public class FileOperations {

    public static ArrayList<Job> read() {
        return read("config.xml");
    }
    
    public static ArrayList<Job> read(String filename) {
        ArrayList<Job> results = new ArrayList<Job>();
        File defaultFile = new File(filename);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        try {
            db = dbf.newDocumentBuilder();
            Document doc = db.parse(defaultFile);
            return getJobList(doc);
        } catch (Exception e) {
            return results;
        }
    }
    
    private static ArrayList<Job> getJobList(Document doc) {
        
    }
}
