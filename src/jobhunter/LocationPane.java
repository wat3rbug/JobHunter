package jobhunter;

import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 */
public class LocationPane extends TabPane {
    
    public LocationPane() {
        super("Location");
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
}
