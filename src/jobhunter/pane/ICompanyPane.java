package jobhunter.pane;

import jobhunter.data.Company;

/**
 * @author Douglas Gardiner
 * An interface for the Company Pane.  
 */

public interface ICompanyPane extends IPaneObserver{
 
    /**
     * Returns the Company object from the object that implements this 
     * interface.
     * @return A Company object.
     */
    
    public Company getCompany();
}
