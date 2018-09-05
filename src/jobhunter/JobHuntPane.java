package jobhunter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * @author Douglas Gardiner
 */
public class JobHuntPane extends JPanel {
    
    private static Dimension defaults = new Dimension(180, 220);
    private DefaultListModel<Job> joblist;
    private JList<Job> joblistings;
    private Object delegate;
    private CompanyMiniPane companies;
    private LocationMiniPane locations;
    private JobTitleMiniPane titles;

    public JobHuntPane(Object delegate) {
        
        this.delegate = delegate;
        //joblist = new DefaultListModel<Job>(delegate.joblist);
        
        // first 3 panels that list company, etc for adding a job
        
        companies = new CompanyMiniPane();
        locations = new LocationMiniPane();
        titles = new JobTitleMiniPane();
        
        locations.setBorder(BorderFactory.createTitledBorder("Locations"));
        titles.setBorder(BorderFactory.createTitledBorder("Job Titles"));
        JPanel selectors = new JPanel();
        companies.setPreferredSize(defaults);
        locations.setPreferredSize(defaults);
        titles.setPreferredSize(defaults);
        selectors.add(companies);
        selectors.add(locations);
        selectors.add(titles);
        BoxLayout boxlayout = new BoxLayout(selectors, BoxLayout.X_AXIS);
        this.add(selectors);
        
        // right hand panel top portion with job listings
        
        JPanel jobs = new JPanel();
        jobs.setBorder(BorderFactory.createTitledBorder("Jobs Applied"));
        JScrollPane listScroller = new JScrollPane(joblistings);
        listScroller.setPreferredSize(new Dimension(160, 100));
        jobs.add(listScroller);       
        AddButton adder = new AddButton();
        jobs.add(adder);
        BoxLayout jobsbox = new BoxLayout(jobs, BoxLayout.Y_AXIS);
        this.add(jobs);
    }
    
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            
        }
        
    }
    
    public void addJobListings(Job[] jobs) {
        joblistings = new JList(jobs);
        joblistings.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        joblistings.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        joblistings.setVisibleRowCount(-1);
    }
}
