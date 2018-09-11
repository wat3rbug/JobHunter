package jobhunter.pane;

import java.awt.Dimension;
import jobhunter.data.Job;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import jobhunter.AddButton;
import jobhunter.minipane.CompanyMiniPane;
import jobhunter.minipane.JobTitleMiniPane;
import jobhunter.minipane.LocationMiniPane;

/**
 * @author Douglas Gardiner
 */
public class JobHuntPane extends JPanel {
    
    
    private DefaultListModel joblist;
    private JList joblistings;
    private CompanyMiniPane companies;
    private LocationMiniPane locations;
    private JobTitleMiniPane titles;
    private ArrayList<Job> jobs;

    public JobHuntPane(Object delegate) {
        
        // first 3 panels that list company, etc for adding a job
        
        companies = new CompanyMiniPane();
        locations = new LocationMiniPane();
        titles = new JobTitleMiniPane();
        jobs = new ArrayList<Job>();
        
        titles.setBorder(BorderFactory.createTitledBorder("Job Titles"));
        companies.setBorder(BorderFactory.createTitledBorder("Companies"));
        locations.setBorder(BorderFactory.createTitledBorder("Locations"));
        JPanel selectors = new JPanel();

        selectors.add(titles);
        selectors.add(companies);
        selectors.add(locations);
        BoxLayout boxlayout = new BoxLayout(selectors, BoxLayout.X_AXIS);
        this.add(selectors);
        
        // right hand panel top portion with job listings
        
        JPanel jobs = new JPanel();
        jobs.setBorder(BorderFactory.createTitledBorder("Jobs Applied"));
        joblist = new DefaultListModel();
        joblistings = new JList(joblist);
        JScrollPane listScroller = new JScrollPane(joblistings);
        jobs.add(listScroller);       
        AddButton adder = new AddButton();
        jobs.add(adder);
        BoxLayout jobsbox = new BoxLayout(jobs, BoxLayout.Y_AXIS);
        listScroller.setPreferredSize(new Dimension(180, 120));
        
        this.add(jobs);
    }
    
    private class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Job job = new Job();
            job.company = companies.getSelected();
            job.loc = locations.getSelected();
            job.title = titles.getSelected();
            job.hadInterview = false;
            job.date = new Date();
            jobs.add(job);
            joblist.addElement(job);
        }      
    }
    
    public void addJob(Job job) {
        jobs.add(job);
        companies.addCompany(job.company);
        titles.addTitle(job.title);
        locations.addLocation(job.loc);
        joblist.addElement(job.toBriefString());
    }
}
