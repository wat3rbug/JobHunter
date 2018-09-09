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
}
