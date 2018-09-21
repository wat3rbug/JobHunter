package jobhunter.pane;

import jobhunter.data.Location;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
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

    @Override
    public Location getLoc() {
        return temp;
    }

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
