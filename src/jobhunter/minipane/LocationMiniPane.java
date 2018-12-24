package jobhunter.minipane;

import jobhunter.data.Location;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 * A basic mini display which is used on the JobHunt Pane.  It displays a brief
 * synopsis of the location as it exists as an option.
 */
public class LocationMiniPane extends MiniPane {

    private DefaultListModel<Location> listing;
    private JList<Location> locationListing;
    private JScrollPane scroller;
    
    public LocationMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Locations"));
        listing = new DefaultListModel<Location>();
        locationListing = new JList<Location>(listing);
        scroller = new JScrollPane(locationListing);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(180, 120));
        this.add(scroller);
    }   
    
    /**
     * Adds a Location object to the listing so that it can be displayed.
     * @param loc The Location object that is to be added to the display.
     */
    
    public void addLocation(Location loc) {
        int found = -1;
        int max = listing.getSize();
        for (int i = 0; i < max; i++) {
            if (listing.get(i).loc.toLowerCase().equals(
                    loc.loc.toLowerCase())) {
                found = i;
            }
        }
        if (found == -1) {
            listing.addElement(loc);
        }
    }
    
    /**
     * Returns the selected Location object from the pane.  NOTE: Only one 
     * job title can be selected. 
     * @return The Location object that is derived from the listing.
     */
    
    public Location getSelected() {
        return locationListing.getSelectedValue();
    }
}
