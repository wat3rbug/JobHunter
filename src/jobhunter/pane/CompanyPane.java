package jobhunter.pane;

import jobhunter.data.Company;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jobhunter.StringExtender;

/**
 * @author Douglas Gardiner
 */

public class CompanyPane extends TabPane implements ICompanyPane {

    protected JCheckBox checker;
    private ArrayList<Company> companies;
    private Company temp;
    private ChangeListener delegate;
    
    
    public CompanyPane(ChangeListener delegate) {
        super("Company");    
        this.delegate = delegate;
        companies = new ArrayList<Company>();
        adder.addActionListener(new AddListener());
        addEntryField("Staffing", true);

    }

    @Override
    public Company getCompany() {
        return temp;
    }

    @Override
    public void setDelegate(ChangeListener delegate) {
        this.delegate = delegate;
    }
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = insertField.getText();
            boolean staffing = checker.isSelected();
            String isStaffing = StringExtender.toYesNoString(staffing);
            temp = new Company(name, isStaffing);
            companies.add(temp);
            addEntry(temp.toString());
            if (delegate != null) delegate.receivedUpdate(CompanyPane.this);
        }     
    }

    private void addEntryField(String text, boolean isCheckBox) {
        if (isCheckBox) AddCheckBox(text);
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
