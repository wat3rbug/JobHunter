package jobhunter;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;

/**
 * @author Douglas Gardiner
 * Base class for the other panes so that I can modify some of the behaviors   
 */

public class TabPane extends JTabbedPane {

    protected JLabel insertLabel;
    protected JTextField insertField;

    private static final long serialVersionUID = 5518322545480912355L;

    public TabPane(String text) {
        insertLabel = new JLabel(text);
        insertField = new JTextField();
        JPanel listingPanel = new JPanel();
        JList listings = new JList();


    }
}
