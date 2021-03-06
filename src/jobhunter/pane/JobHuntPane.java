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

    public JobHuntPane() {
        
        // first 3 panels that list company, etc for adding a job
        
        companies = new CompanyMiniPane();
        locations = new LocationMiniPane();
        titles = new JobTitleMiniPane();
        recruiters = new RecruiterMiniPane();
        languages = new LanguageMiniPane();
        jobs = new ArrayList<Job>();
        
        AddButton adder = new AddButton();
        
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
        
        // bottom panel with job listings
        
        joblist = new DefaultListModel();
        joblistings = new JList(joblist);
        JScrollPane listScroller = new JScrollPane(joblistings);
        listScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        Dimension miniDim = titles.getSize();
        
        listScroller.setMinimumSize(new Dimension((180 * 3), 120));
        listScroller.setPreferredSize(new Dimension((180 * 3), 120));
        
        JPanel jobs = new JPanel();
        jobs.setBorder(BorderFactory.createTitledBorder("Jobs Applied"));
        jobs.add(listScroller); 

        
        this.add(selectorsTopRow);
        this.add(selectorsMiddleRow);
        this.add(jobs);
        BoxLayout overall = new BoxLayout(this, BoxLayout.Y_AXIS);
    }
    
    public void addCompany(Company comp) {
        companies.addCompany(comp);
    }
    
    public void addTitle(JobTitle title) {
        titles.addTitle(title);
    }
    
    public void addLanguage(Language lang) {
        languages.addLanguage(lang);
    }
    
    public void addLoc(Location loc) {
        locations.addLocation(loc);
    }
    
    public void addRecruiter(Recruiter recruit) {
        recruiters.addRecruiter(recruit);
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
    
    public ArrayList<Job> getJobs() {
        return jobs;
    }
    
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
