package jobhunter.minipane;

import jobhunter.data.JobTitle;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 * A basic mini display which is used on the JobHunt Pane.  It displays a brief
 * synopsis of the job title as it exists as an option.
 */

public class JobTitleMiniPane extends MiniPane{

    private DefaultListModel<JobTitle> listing;
    private JList<JobTitle> titleListing;
    private JScrollPane scroller;
    
    public JobTitleMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Job Titles"));
        listing = new DefaultListModel<JobTitle>();
        titleListing = new JList<JobTitle>(listing);
        scroller = new JScrollPane(titleListing);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(180, 120));
        this.add(scroller);
    }
    
    /**
     * Adds a JobTitle object to the listing so that it can be displayed.
     * @param title The JobTitle object that is to be added to the display.
     */
    
    public void addTitle(JobTitle title) {
        if (!listing.contains(title.toString())) listing.addElement(title);
    }
    
    /**
     * Returns the selected JobTitle object from the pane.  NOTE: Only one 
     * job title can be selected. 
     * @return The JobTitle object that is derived from the listing.
     */
    
    public JobTitle getSelected() {
        return titleListing.getSelectedValue();
    }
}
