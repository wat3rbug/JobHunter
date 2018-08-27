package jobhunter;

import java.awt.FlowLayout;
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
        JLabel insertLabel = new JLabel(text);
        JTextField insertField = new JTextField();
        JList listing = new JList();
        JPanel listingPanel = new JPanel();
        JPanel addPanel = new JPanel();
        JPanel overallPanel = new JPanel();
        
        addPanel.setBorder(BorderFactory.createTitledBorder(text));
        FlowLayout flow = new FlowLayout(FlowLayout.LEADING);
        addPanel.setLayout(flow);
        AddButton adder = new AddButton();
        JList listings = new JList();
        addPanel.add(insertLabel);
        addPanel.add(insertField);
        addPanel.add(adder);
        
        listingPanel.add(addPanel);

        listingPanel.add(adder);
        listingPanel.add(listings);

    }
}
