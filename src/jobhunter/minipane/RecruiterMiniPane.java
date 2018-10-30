package jobhunter.minipane;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import jobhunter.data.Recruiter;

/**
 * @author Douglas Gardiner
 * A basic mini display which is used on the JobHunt Pane.  It displays a brief
 * synopsis of the recruiter as it exists as an option.
 */
public class RecruiterMiniPane extends MiniPane {

    private DefaultListModel<Recruiter> listing;
    private JList<Recruiter> recruiterListing;
    private JScrollPane scroller;
    
    public RecruiterMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Job Sites"));
        listing = new DefaultListModel<Recruiter>();
        recruiterListing = new JList<Recruiter>(listing);
        scroller = new JScrollPane(recruiterListing);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(180, 120));
        this.add(scroller);
    }   
    
    /**
     * Adds a Recruiter object to the listing so that it can be displayed.
     * @param recruit The Recruiter object that is to be added to the display.
     */
    
    public void addRecruiter(Recruiter recruit) {
        if (!listing.contains(recruit.toString())) listing.addElement(recruit);
    }
    
    /**
     * Returns the selected Recruiter object from the pane.  NOTE: Only one 
     * recruiter can be selected. 
     * @return The Recruiter object that is derived from the listing.
     */
    
    public Recruiter getSelected() {
        return recruiterListing.getSelectedValue();
    }
}
