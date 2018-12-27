/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jobhunter.pane;

import java.util.Date;

/**
 *
 * @author Your Name <Douglas Gardiner>
 */
public interface IDatePane extends IPaneObserver {
    
    public Date getSelectedDate();
}
