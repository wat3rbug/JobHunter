package jobhunter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 */
public class JobTitlePane extends TabPane {
    
    protected JCheckBox checker;
    protected DefaultListModel<JobTitle> objectListings;
    protected JList<JobTitle> jobTitleListing;
    protected JScrollPane scroller;

    public JobTitlePane() {
        super("Job Title");
        objectListings = new DefaultListModel<JobTitle>();
        jobTitleListing = new JList<JobTitle>(objectListings);
        scroller = new JScrollPane(jobTitleListing);
        listingPanel.add(scroller);
        adder.addActionListener(new AddListener());
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JobTitle temp = new JobTitle(insertField.getText());
            addEntry(temp);
        }     
    }
    
    private void addEntry(JobTitle title) {
        if (title != null) {
            objectListings.addElement(title);
            jobTitleListing = new JList(objectListings);
        }
    }
}
