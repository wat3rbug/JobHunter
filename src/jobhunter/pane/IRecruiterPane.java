/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobhunter.pane;

import jobhunter.data.Recruiter;

/**
 *
 * @author Your Name <Douglas Gardiner>
 */
public interface IRecruiterPane extends IPaneObserver{
    
    public Recruiter getRecruiter();
}
