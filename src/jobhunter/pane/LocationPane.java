package jobhunter.pane;

import jobhunter.pane.TabPane;
import jobhunter.data.Location;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 */
public class LocationPane extends TabPane {
    
    private ArrayList<Location> locationListing;
    
    public LocationPane() {
        super("Location");
        locationListing = new ArrayList<Location>();
        adder.addActionListener(new AddListener());
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Location temp = new Location(insertField.getText());
            locationListing.add(temp);
            addEntry(temp.toString());
        }     
    }
}
