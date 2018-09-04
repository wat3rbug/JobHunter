package jobhunter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 */
public class JobTitlePane extends TabPane {

    public JobTitlePane() {
        super("Job Title");
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
    public void addEntry(String text, boolean isCheckBox) { }
}
