package jobhunter.pane;

import jobhunter.data.JobTitle;

/**
 * @author Douglas Gardiner
 * An interface for the JobTitle Pane.  
 */

public interface IJobTitlePane extends IPaneObserver{
    
    /**
     * Returns the JobTitle object from the object that implements this 
     * interface.
     * @return A JobTitle object.
     */
    
    public JobTitle getJobTitle();
}
