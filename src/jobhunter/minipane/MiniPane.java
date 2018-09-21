package jobhunter.minipane;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JPanel;
import jobhunter.pane.ChangeListener;

/**
 * @author Douglas Gardiner
 */
public abstract class MiniPane extends JPanel {

    private JList listing;

    public void setListing(JList listing) {
        this.listing = listing;       
    }
}
