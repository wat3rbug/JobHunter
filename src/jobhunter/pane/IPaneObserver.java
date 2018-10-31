package jobhunter.pane;

/**
 * A based interface that sets up an observer pattern.  This is a slight 
 * deviation because only a base model needs to exist.  Java implementation has
 * some limitations as it is NOT an interface but a class with some class
 * restrictions.
 * @author Douglas Gardiner
 */

public interface IPaneObserver {
    
    /**
     * Sets the reference to an object which implements the IChangeListener
     * interface. 
     * @param delegate The object reference that meets the IChangeListener 
     * interface. 
     */
    
    public void setDelegate(IChangeListener delegate);
}
