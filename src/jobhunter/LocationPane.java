package jobhunter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 */
public class LocationPane extends TabPane {
    
    public LocationPane() {
        super("Location");
        super.adder.addActionListener(new Listener());
    }
    
    @Override
    public void addEntry(String text, boolean isCheckBox) {
    }

    /**
     * Adds an array-list of locations for use with the list.
     * @param listings ArrayList of locations. 
     */
    @Override
    public void addObjectList(ArrayList listings) {
        super.objectListing = listings;
        
    }

    private class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (objectListing != null) {
                Location temp = new Location(insertField.getText());
                objectListing.add(temp);
            }
        }
    }
}
