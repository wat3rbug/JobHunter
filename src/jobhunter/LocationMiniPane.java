package jobhunter;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 */
public class LocationMiniPane extends MiniPane implements Observer {

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
    
    @Override
    public Object[] getListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
