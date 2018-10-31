package jobhunter.pane;

import jobhunter.data.JobTitle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 * A Tabbed Pane used for displaying JobTitle info to add to the main job hunt 
 * pane.
 */

public class JobTitlePane extends TabPane implements IJobTitlePane {
    
    private ArrayList<JobTitle> titleListing;
    private JobTitle temp;
    IChangeListener delegate;

    public JobTitlePane(IChangeListener delegate) {
        super("Job Title");
        this.delegate = delegate;
        titleListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }

    /**
     * Returns the JobTitle object that was added via this pane.  It is used by 
     * the delegate object.  See IChangeListener for implementation details.
     * @return The JobTitle object that was added via this pane.
     */
    
    @Override
    public JobTitle getJobTitle() {
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
            temp = new JobTitle(insertField.getText());
            titleListing.add(temp);
            addEntry(temp.toString());
            if (delegate != null) delegate.receivedUpdate(JobTitlePane.this);
        }     
    }
}
