package jobhunter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Douglas Gardiner
 */

public class CompanyPane extends TabPane {

    public CompanyPane() {
        super("Company");
        addEntry("Staffing", true);
        super.adder.addActionListener(new AddListener());
    }
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String temp = insertField.getText();
            addEntry(temp);
        }     
    }

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
