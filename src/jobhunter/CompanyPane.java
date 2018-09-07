package jobhunter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 * @author Douglas Gardiner
 */

public class CompanyPane extends TabPane {

    protected DefaultListModel<Company> objectListings;
    protected JList<Company> companyListing;
    protected JCheckBox checker;
    protected JScrollPane scroller;
    
    
    public CompanyPane() {
        super("Company");
        addEntry("Staffing", true);
        objectListings = new DefaultListModel<Company>();
        companyListing = new JList<Company>(objectListings);
        scroller = new JScrollPane(companyListing);
        listingPanel.add(scroller);
        adder.addActionListener(new AddListener());
        
    }
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String temp = insertField.getText();
            boolean isStaffing = StringExtender.toBooleanValue(checker.getText());
            addEntry(temp, isStaffing);
        }     
    }

    private void addEntry(String text, boolean isCheckBox) {
        if (isCheckBox) 
            AddCheckBox(text);
        else AddTextBox(text);
    }
    
    private void AddCheckBox(String text) {
        checker = new JCheckBox(text);
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
