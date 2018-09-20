package jobhunter.minipane;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import jobhunter.data.Recruiter;

/**
 * @author Douglas Gardiner
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
    
    public void addRecruiter(Recruiter recruit) {
        if (!listing.contains(recruit.toString())) listing.addElement(recruit);
    }
    
    public Recruiter getSelected() {
        return recruiterListing.getSelectedValue();
    }
}
