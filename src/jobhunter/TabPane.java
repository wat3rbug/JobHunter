package jobhunter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 * Base class for the other panes so that I can modify some of the behaviors   
 */

public abstract class TabPane extends JPanel {

    private static final long serialVersionUID = 5518322545480912355L;
    protected final JPanel addPanel;
    protected final JPanel listingPanel;
    protected final AddButton adder;
    protected JTextField insertField;
    JList<String> listings;
    DefaultListModel<String> objectListings;

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
         
        objectListings = new DefaultListModel();
        listings = new JList(objectListings);
        
        JScrollPane scroller = new JScrollPane(listings);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listingPanel.add(scroller);
        
        GridLayout grid = new GridLayout(1, 2);
        this.setLayout(grid);
        this.add(addPanel);
        this.add(listingPanel);
    }

    public void addEntry(String text) {
        if (text != null) {
            objectListings.addElement(text);
            listings = new JList(objectListings);
        }
    }
    /**
     * Allows additional boxes to be added in future use cases.
     * @param text The title for the text to be entered.
     * @param isCheckBox Determines if the input is a check-box or not.
     */
    
    public abstract void addEntry(String text, boolean isCheckBox);   
}
