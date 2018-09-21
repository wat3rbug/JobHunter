package jobhunter.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jobhunter.data.Recruiter;

/**
 * @author Douglas Gardiner
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

    @Override
    public Recruiter getRecruiter() {
        return temp;
    }

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
