package jobhunter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 */
public class LocationPane extends TabPane {
    
    protected DefaultListModel<Location> objectListings;
    protected JList<Location> locationListing;
    protected JScrollPane scroller;
    
    public LocationPane() {
        super("Location");
        objectListings = new DefaultListModel<Location>();
        locationListing = new JList<Location>(objectListings);
        scroller = new JScrollPane(locationListing);
        listingPanel.add(scroller);
        adder.addActionListener(new AddListener());
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Location temp = new Location(insertField.getText());
            addEntry(temp);
        }     
    }
    private void addEntry(Location loc) {
        if (loc != null) {
            objectListings.addElement(loc);
            locationListing = new JList(objectListings);
        }
    }
}
