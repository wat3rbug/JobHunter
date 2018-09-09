package jobhunter.pane;

import jobhunter.pane.TabPane;
import jobhunter.data.JobTitle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 */
public class JobTitlePane extends TabPane {
    
    private ArrayList<JobTitle> titleListing;

    public JobTitlePane() {
        super("Job Title");
        titleListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JobTitle temp = new JobTitle(insertField.getText());
            titleListing.add(temp);
            addEntry(temp.toString());
        }     
    }
}
