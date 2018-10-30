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

    public void setListing(JList listing) {
        this.listing = listing;       
    }
}
