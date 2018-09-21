/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobhunter.pane;

/**
 *
 * @author Your Name <Douglas Gardiner>
 */
public interface IChangeListener {
    
    /**
     * Provides a method for the class to do an update on the object it is 
     * listening for changes on.
     */
    public void receivedUpdate(ICompanyPane pane);
    
    public void receivedUpdate(IJobTitlePane pane);
    
    public void receivedUpdate(ILanguagePane pane);
    
    public void receivedUpdate(ILocationPane pane);
    
    public void receivedUpdate(IRecruiterPane pane); 
}
