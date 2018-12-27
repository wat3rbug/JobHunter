package jobhunter.pane;

/**
 * @author Douglas Gardiner
 * An interface for Interfaces because I could not find a better way to do it
 * in Java with the class limitation on listener/observer model.  There will
 * probably be some technical debt if this gets more complicated.
 */

public interface IChangeListener {
    
    /**
     * Provides a method for the class to do an update on the object it is 
     * listening for changes on.
     * @param pane The pane that wishes to listen for changes.  Must conform to
     * the ICompanyPane interface which also conforms to the IPaneObserver 
     * interface.
     */
    
    public void receivedUpdate(ICompanyPane pane);
    
    /**
     * Provides a method for the class to do an update on the object it is 
     * listening for changes on.
     * @param pane The pane that wishes to listen for changes.  Must conform to
     * the IJobTitlePane interface which also conforms to the IPaneObserver 
     * interface.
     */
    
    public void receivedUpdate(IJobTitlePane pane);
    
    /**
     * Provides a method for the class to do an update on the object it is 
     * listening for changes on.
     * @param pane The pane that wishes to listen for changes.  Must conform to
     * the ILanguagePane interface which also conforms to the IPaneObserver 
     * interface.
     */
    
    public void receivedUpdate(ILanguagePane pane);
    
    /**
     * Provides a method for the class to do an update on the object it is 
     * listening for changes on.
     * @param pane The pane that wishes to listen for changes.  Must conform to
     * the ILocationPane interface which also conforms to the IPaneObserver 
     * interface.
     */
    
    public void receivedUpdate(ILocationPane pane);
    
    /**
     * Provides a method for the class to do an update on the object it is 
     * listening for changes on.
     * @param pane The pane that wishes to listen for changes.  Must conform to
     * the IRecruiterPane interface which also conforms to the IPaneObserver 
     * interface.
     */
    
    public void receivedUpdate(IRecruiterPane pane); 
    
    public void receivedUpdate(IDatePane pane);
}
