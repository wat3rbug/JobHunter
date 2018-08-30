package jobhunter;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;

/**
 * @author Douglas Gardiner
 * Base class for the other panes so that I can modify some of the behaviors   
 */

public class TabPane extends JPanel {

    private static final long serialVersionUID = 5518322545480912355L;

    public TabPane(String text) {
        JPanel listingPanel = new JPanel();
        JPanel addPanel = new JPanel();
        JPanel overallPanel = new JPanel();
        
        JLabel insertLabel = new JLabel(text);
        JTextField insertField = new JTextField();
        
        JList listing = new JList();
     
        addPanel.setBorder(BorderFactory.createTitledBorder(text));
        FlowLayout flow = new FlowLayout(FlowLayout.LEADING);
        addPanel.setLayout(flow);
        AddButton adder = new AddButton();
        addPanel.add(insertLabel);
        addPanel.add(insertField);
        addPanel.add(adder);
               
        JList listings = new JList();
        listingPanel.add(listings);
        
        GridLayout grid = new GridLayout(2, 1);
        overallPanel.setLayout(grid);
        overallPanel.add(addPanel);
        overallPanel.add(listingPanel);
    }
}
