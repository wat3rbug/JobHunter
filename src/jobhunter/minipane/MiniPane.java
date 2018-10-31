package jobhunter.minipane;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import jobhunter.pane.IChangeListener;

/**
 * @author Douglas Gardiner
 * A basic mini display which is used on the JobHunt Pane.  It contains the
 * scaffolding needed for the classes that inherit the properties, and nothing
 * more.
 */

public abstract class MiniPane extends JPanel {

    private JList listing;
    
    /**
     * This method provides a way to add a JList to the base pane for modularity
     * purposes.
     * @param listing The JList to add to the pane. 
     */

    public void setListing(JList listing) {
        this.listing = listing;       
    }
}
