package jobhunter.pane;

import jobhunter.data.Recruiter;

/**
 * @author Douglas Gardiner
 * An interface for the Recruiter Pane.  
 */

public interface IRecruiterPane extends IPaneObserver{
    
    /**
     * Returns the Recruiter object from the object that implements this 
     * interface.
     * @return A Recruiter object.
     */
    
    public Recruiter getRecruiter();
}
