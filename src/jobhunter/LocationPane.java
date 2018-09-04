package jobhunter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Douglas Gardiner
 */
public class LocationPane extends TabPane {
    
    public LocationPane() {
        super("Location");
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
    }
}
