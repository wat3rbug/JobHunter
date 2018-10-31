package jobhunter;

/**
 * @author Douglas Gardiner
 * This is just a basic extension because this button will be used in several 
 * places.  The compiler complained about serialization, which I doubt I'll 
 * ever use.  This is just a quick little over the weekend project to check 
 * skill-set with Java since I haven't used it in years.
 */

import javax.swing.JButton;

public class InterviewButton extends JButton {
    
    public InterviewButton() {
        //ImageIcon icon = UIManager.getI
        this.setText("Interview");
    }
}
