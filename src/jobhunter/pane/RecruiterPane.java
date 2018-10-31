package jobhunter.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jobhunter.data.Recruiter;

/**
 * @author Douglas Gardiner
 * A Tabbed Pane used for displaying Recruiter info to add to the main job hunt 
 * pane.
 */
public class RecruiterPane extends TabPane implements IRecruiterPane {

    private ArrayList<Recruiter> recruiterListing;
    private Recruiter temp;
    private IChangeListener delegate;

    public RecruiterPane(IChangeListener delegate) {
        super("Job Hunt Sites");
        this.delegate = delegate;
        recruiterListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }
    
    /**
     * Returns the Recruiter object that was added via this pane.  It is used by 
     * the delegate object.  See IChangeListener for implementation details.
     * @return The Recruiter object that was added via this pane.
     */

    @Override
    public Recruiter getRecruiter() {
        return temp;
    }

    /**
     * Sets a delegate so that when changes occur to this pane, the delegate
     * is notified.  This uses the IChangeListener interface so that only 
     * classes that use this interface can participate.  The delegate is an 
     * optional object.
     * @param delegate The IChangeListener object that will be notified when a 
     * change occurs.
     */
    
    @Override
    public void setDelegate(IChangeListener delegate) {
        this.delegate = delegate;
    }
   
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            temp = new Recruiter(insertField.getText());
            recruiterListing.add(temp);
            addEntry(temp.toString());
            if (delegate != null ) delegate.receivedUpdate(RecruiterPane.this);
        }     
    }
}
