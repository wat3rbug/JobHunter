package jobhunter.minipane;

import jobhunter.data.JobTitle;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
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
    
    public void addTitle(JobTitle title) {
        if (!listing.contains(title.toString())) listing.addElement(title);
    }
    
    public JobTitle getSelected() {
        return titleListing.getSelectedValue();
    }
}
