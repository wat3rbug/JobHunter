package jobhunter;

import javax.swing.JButton;

/**
 * @author Douglas Gardiner
 * This is just a basic extension because this button will be used in several 
 * places.  The compiler complained about serialization, which I doubt I'll 
 * ever use.  This is just a quick little over the weekend project to check 
 * skill-set with Java since I haven't used it in years.
 */

public class RemoveButton extends JButton {

    private static final long serialVersionUID = -1019539337741869744L;
    
    public RemoveButton() {
        this.setText("Remove");
    }
}
