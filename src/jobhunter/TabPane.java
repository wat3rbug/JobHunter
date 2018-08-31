package jobhunter;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JList;

/**
 * @author Douglas Gardiner
 * Base class for the other panes so that I can modify some of the behaviors   
 */

public class TabPane extends JPanel implements ITabPane {

    private static final long serialVersionUID = 5518322545480912355L;
    private JPanel addPanel;
    private JPanel listingPanel;
    private AddButton adder;

    public TabPane(String text) {
        listingPanel = new JPanel();
        addPanel = new JPanel();
        
        JLabel insertLabel = new JLabel(text);
        JTextField insertField = new JTextField();
     
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
    
    @Override
    public void addEntry(String text, boolean isCheckBox) {
        if (isCheckBox) 
            AddCheckBox(text);
        else AddTextBox(text);
    }
    
    private void AddCheckBox(String text) {
        JCheckBox checker = new JCheckBox(text);
        addPanel.remove(adder);
        addPanel.add(checker);
        addPanel.add(adder);
    }
    
    private void AddTextBox(String text) {
        JPanel newText = new JPanel();
        JLabel labeler = new JLabel(text);
        JTextField insertLabel = new JTextField();
        newText.add(labeler);
        newText.add(insertLabel);
        newText.setLayout(new GridLayout(1, 2));
        
        addPanel.remove(adder);
        addPanel.add(newText);
        addPanel.add(adder);
    }
}
