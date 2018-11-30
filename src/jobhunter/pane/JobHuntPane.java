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
import jobhunter.AddButton;
import jobhunter.InterviewButton;
import jobhunter.data.Company;
import jobhunter.data.JobTitle;
import jobhunter.data.Language;
import jobhunter.data.Location;
import jobhunter.data.Recruiter;
import jobhunter.minipane.CompanyMiniPane;
import jobhunter.minipane.JobTitleMiniPane;
import jobhunter.minipane.LanguageMiniPane;
import jobhunter.minipane.LocationMiniPane;
import jobhunter.minipane.RecruiterMiniPane;

/**
 * @author Douglas Gardiner
 * A Tabbed Pane used for displaying All the job hunt info for adding jobs that 
 * were applied to, as well as the interview progress.
 */
public class JobHuntPane extends JPanel {
    
    
    private DefaultListModel joblist;
    private JList joblistings;
    private CompanyMiniPane companies;
    private LocationMiniPane locations;
    private JobTitleMiniPane titles;
    private RecruiterMiniPane recruiters;
    private LanguageMiniPane languages;
    private ArrayList<Job> jobs;
    private JScrollPane listScroller;

    public JobHuntPane() {
        
        // first 3 panels that list company, etc for adding a job
        
        companies = new CompanyMiniPane();
        locations = new LocationMiniPane();
        titles = new JobTitleMiniPane();
        recruiters = new RecruiterMiniPane();
        languages = new LanguageMiniPane();
        jobs = new ArrayList<Job>();
        
        AddButton adder = new AddButton();
        InterviewButton interviewBtn = new InterviewButton();
        
        JPanel selectorsTopRow = new JPanel();
        selectorsTopRow.add(titles);
        selectorsTopRow.add(languages);
        selectorsTopRow.add(companies);
        BoxLayout boxlayout = new BoxLayout(selectorsTopRow, BoxLayout.X_AXIS);
        
        JPanel selectorsMiddleRow = new JPanel();
        selectorsMiddleRow.add(locations);
        selectorsMiddleRow.add(recruiters);
        selectorsMiddleRow.add(adder);
        BoxLayout boxLayoutMiddle = new BoxLayout(selectorsMiddleRow, 
                BoxLayout.X_AXIS);
        adder.addActionListener(new AddListener());
        interviewBtn.addActionListener(new InterviewListener());
        
        // bottom panel with job listings
        
        joblist = new DefaultListModel();
        joblistings = new JList(joblist);
        listScroller = new JScrollPane(joblistings);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Dimension miniDim = titles.getSize();
        
        listScroller.setMinimumSize(new Dimension((180 * 3), 120));
        listScroller.setPreferredSize(new Dimension((180 * 3), 120));
        
        JPanel jobs = new JPanel();
        jobs.setBorder(BorderFactory.createTitledBorder("Jobs Applied"));
        jobs.add(listScroller); 

        jobs.add(interviewBtn);
        
        this.add(selectorsTopRow);
        this.add(selectorsMiddleRow);
        this.add(jobs);
        BoxLayout overall = new BoxLayout(this, BoxLayout.Y_AXIS);
    }
    
    /**
     * Used for adding a Company to this panel.  Normally this is done as the 
     * result of a change on the Company Tabbed Pane using this pane as a 
     * delegate.
     * @param comp The Company to add to the CompanyMiniPane.
     */
    
    public void addCompany(Company comp) {
        companies.addCompany(comp);
    }
    
    /**
     * Used for adding a JobTitle to this panel.  Normally this is done as the 
     * result of a change on the Job Title Tabbed Pane using this pane as a 
     * delegate.
     * @param title The JobTitle to add to the JobTitleMiniPane.
     */
    
    public void addTitle(JobTitle title) {
        titles.addTitle(title);
    }
    
    /**
     * Used for adding a Language to this panel.  Normally this is done as the 
     * result of a change on the Language Tabbed Pane using this pane as a 
     * delegate.
     * @param lang The Language to add to the LanguageMiniPane.
     */
    
    public void addLanguage(Language lang) {
        languages.addLanguage(lang);
    }
    
    /**
     * Used for adding a Location to this panel.  Normally this is done as the 
     * result of a change on the Location Tabbed Pane using this pane as a 
     * delegate.
     * @param loc The Location to add to the LocationMiniPane.
     */
    
    public void addLoc(Location loc) {
        locations.addLocation(loc);
    }
    
    /**
     * Used for adding a Recruiter to this panel.  Normally this is done as the 
     * result of a change on the Recruiter Tabbed Pane using this pane as a 
     * delegate.
     * @param loc The Recruiter to add to the RecruiterMiniPane.
     */
    
    public void addRecruiter(Recruiter recruit) {
        recruiters.addRecruiter(recruit);
    }
    
    private class InterviewListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            String temp = (String)joblistings.getSelectedValue();
            Job selectedTarget = null;
            for (Job job : jobs) {
                if (temp.contains(job.company.companyName) && 
                        temp.contains(job.title.jobTitle))
                {
                    if ((job.recruiter!= null && temp.contains(job.recruiter.recruiter)) 
                             || (job.recruiter == null)) {
                        job.hadInterview = true;
                        selectedTarget = job;
                    }
                }
            }
            // redo the jlist -- still BROKE
            
            
//            if (selectedTarget != null) {
//                joblist.addElement(selectedTarget.toBriefString());
//                joblistings.remove(joblistings.getSelectedIndex());
//            }
                
            joblistings.updateUI();
        }
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
            job.recruiter = recruiters.getSelected();
            job.langs = languages.getSelected();
            jobs.add(job);
            joblist.addElement(job.toBriefString());
        }      
    }
    
    /**
     * Gets the ArrayList of jobs from the pane.
     * @return An ArrayList of Job objects from the pane.
     */
    
    public ArrayList<Job> getJobs() {
        return jobs;
    }
    
    /**
     * Adds a job to the pane.  Used during the initial load of the application
     * where the panel is populated based on the file used.
     * @param job The Job object after it has been converted from XML.
     */
    
    public void addJob(Job job) {
        jobs.add(job);
        if (job.company != null) companies.addCompany(job.company);
        if (job.title != null) titles.addTitle(job.title);
        if (job.loc != null) locations.addLocation(job.loc);
        if (job.recruiter != null) recruiters.addRecruiter(job.recruiter);
        if (job.langs != null) {
            for (int i = 0; i < job.langs.size(); i++) {
                languages.addLanguage(job.langs.get(i));
            }
        }
        joblist.addElement(job.toBriefString());
    }
}
