package jobhunter.pane;

import jobhunter.data.Location;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 * A Tabbed Pane used for displaying Location info to add to the main job hunt 
 * pane.
 */

public class LocationPane extends TabPane implements ILocationPane {
    
    private ArrayList<Location> locationListing;
    private Location temp;
    public IChangeListener delegate;
    
    public LocationPane(IChangeListener delegate) {
        super("Location");
        this.delegate = delegate;
        locationListing = new ArrayList<>();
        adder.addActionListener(new AddListener());
    }
    
    /**
     * Returns the Location object that was added via this pane.  It is used by 
     * the delegate object.  See IChangeListener for implementation details.
     * @return The Location object that was added via this pane.
     */

    @Override
    public Location getLoc() {
        return temp;
    }

    /**
     * Sets a delegate so that when changes occur to this pane, the delegate
     * is notified.  This uses the IChangeListener interface so that only 
     * classes that use this interface can participate.  The delegate is an 
     * optional object.
     * @param delegate The IChangeListener object that will be notified when a 
     * change occurs.
     */
    
    @Override
    public void setDelegate(IChangeListener delegate) {
        this.delegate = delegate;
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            temp = new Location(insertField.getText());
            locationListing.add(temp);
            addEntry(temp.toString());
            if (delegate != null) delegate.receivedUpdate(LocationPane.this);
        }     
    }
}
