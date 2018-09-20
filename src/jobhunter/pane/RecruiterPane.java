package jobhunter.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jobhunter.data.Language;
import jobhunter.data.Recruiter;

/**
 * @author Douglas Gardiner
 */
public class RecruiterPane extends TabPane {

    private ArrayList<Recruiter> recruiterListing;

    public RecruiterPane() {
        super("Job Hunt Sites");
        recruiterListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Recruiter temp = new Recruiter(insertField.getText());
            recruiterListing.add(temp);
            addEntry(temp.toString());
        }     
    }
}
