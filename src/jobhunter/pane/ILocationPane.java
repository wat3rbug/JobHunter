package jobhunter.pane;

import jobhunter.data.Location;

/**
 * @author Douglas Gardiner
 * An interface for the Location Pane.  
 */

public interface ILocationPane extends IPaneObserver{
    
    /**
     * Returns the Location object from the object that implements this 
     * interface.
     * @return A Location object.
     */
    
    public Location getLoc();
    
}
