package jobhunter.pane;

import jobhunter.data.JobTitle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
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

    @Override
    public JobTitle getJobTitle() {
        return temp;
    }

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
