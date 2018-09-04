package jobhunter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;

/**
 * @author Douglas Gardiner
 * Base class for the other panes so that I can modify some of the behaviors   
 */

public abstract class TabPane extends JPanel {

    private static final long serialVersionUID = 5518322545480912355L;
    protected final JPanel addPanel;
    protected final JPanel listingPanel;
    protected final AddButton adder;
    protected ArrayList objectListing;
    protected JTextField insertField;

    public TabPane(String text) {
        listingPanel = new JPanel();
        addPanel = new JPanel();
        
        JLabel insertLabel = new JLabel(text);
        insertField = new JTextField();
     
        addPanel.setBorder(BorderFactory.createEtchedBorder());
        BoxLayout flow = new BoxLayout(addPanel, BoxLayout.Y_AXIS);
        addPanel.setLayout(flow);
        adder = new AddButton();
        addPanel.add(insertLabel);
        addPanel.add(insertField);
        addPanel.add(adder);
               
        JList listings = new JList();
        listingPanel.add(listings);
        
        GridLayout grid = new GridLayout(1, 2);
        this.setLayout(grid);
        this.add(addPanel);
        this.add(listingPanel);
    }

    /**
     * Allows additional boxes to be added in future use cases.
     * @param text The title for the text to be entered.
     * @param isCheckBox Determines if the input is a check-box or not.
     */
    
    public abstract void addEntry(String text, boolean isCheckBox);
    
    public abstract void addObjectList(ArrayList listing);
    
}
