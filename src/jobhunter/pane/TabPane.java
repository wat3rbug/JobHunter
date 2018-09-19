package jobhunter.pane;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Collection;
import java.util.Set;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import jobhunter.AddButton;

/**
 * @author Douglas Gardiner
 * Base class for the other panes so that I can modify some of the behaviors   
 */

public class TabPane extends JPanel {

    private static final long serialVersionUID = 5518322545480912355L;
    protected final JPanel addPanel;
    protected final JPanel listingPanel;
    protected final AddButton adder;
    protected JTextField insertField;
    protected DefaultListModel objectListing;
    private JList listing;
    private JScrollPane scroller;
    protected static Dimension inputDefault = new Dimension(200, 30);
    protected static Dimension listingDefault = new Dimension(350, 230);

    public TabPane(String text) {
        listingPanel = new JPanel();
        addPanel = new JPanel();
        
        JLabel insertLabel = new JLabel(text);
        insertField = new JTextField();
        insertField.setPreferredSize(inputDefault);
        insertField.setMaximumSize(inputDefault);
        objectListing = new DefaultListModel();
        listing = new JList(objectListing);
        scroller = new JScrollPane(listing);
        scroller.setMinimumSize(listingDefault);
        scroller.setPreferredSize(listingDefault);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        listingPanel.add(scroller);
     
        addPanel.setBorder(BorderFactory.createEtchedBorder());
        BoxLayout flow = new BoxLayout(addPanel, BoxLayout.Y_AXIS);
        addPanel.setLayout(flow);
        adder = new AddButton();
        addPanel.add(insertLabel);
        addPanel.add(insertField);
        addPanel.add(adder);
        
        GridLayout grid = new GridLayout(1, 2);
        this.setLayout(grid);
        this.add(addPanel);
        this.add(listingPanel);
    }
    
    public void addEntry(String text) {
        if (!objectListing.contains(text)) objectListing.addElement(text);
    }
}
