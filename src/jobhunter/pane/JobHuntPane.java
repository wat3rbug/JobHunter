package jobhunter.pane;

import java.awt.Dimension;
import jobhunter.data.Job;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import jobhunter.AddButton;
import jobhunter.data.Company;
import jobhunter.minipane.CompanyMiniPane;
import jobhunter.minipane.JobTitleMiniPane;
import jobhunter.minipane.LanguageMiniPane;
import jobhunter.minipane.LocationMiniPane;
import jobhunter.minipane.RecruiterMiniPane;

/**
 * @author Douglas Gardiner
 */
public class JobHuntPane extends JPanel implements PropertyChangeListener{
    
    
    private DefaultListModel joblist;
    private JList joblistings;
    private CompanyMiniPane companies;
    private LocationMiniPane locations;
    private JobTitleMiniPane titles;
    private RecruiterMiniPane recruiters;
    private LanguageMiniPane languages;
    private ArrayList<Job> jobs;

    public JobHuntPane(Object delegate) {
        
        // first 3 panels that list company, etc for adding a job
        
        companies = new CompanyMiniPane();
        locations = new LocationMiniPane();
        titles = new JobTitleMiniPane();
        recruiters = new RecruiterMiniPane();
        languages = new LanguageMiniPane();
        jobs = new ArrayList<Job>();
        
        AddButton adder = new AddButton();
        
        JPanel selectors = new JPanel();
        selectors.add(titles);
        selectors.add(languages);
        selectors.add(companies);
        selectors.add(locations);
        selectors.add(recruiters);
        BoxLayout boxlayout = new BoxLayout(selectors, BoxLayout.X_AXIS);
        
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
        this.add(adder);
        adder.addActionListener(new AddListener());
        
        this.add(selectors);
        this.add(jobs);
        BoxLayout overall = new BoxLayout(this, BoxLayout.Y_AXIS);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        String caller = evt.getClass().getName();
//        if (caller.contains("Company")) companyAdded(evt);
//        if (caller.contains("Title")) titleAdded(evt);
//        if (caller.contains("Language")) companyAdded(evt);
//        if (caller.contains("Location")) titleAdded(evt);
//        if (caller.contains("Recruiter")) recruiterAdded(evt);
    }
    
    private void companyAdded(PropertyChangeEvent pce) {

    }
    
    private void titleAdded(PropertyChangeEvent pce) {
        
    }
        
    private void languageAdded(PropertyChangeEvent pce) {
        
    }
    
    private void locationAdded(PropertyChangeEvent pce) {
        
    }
    
    private void recruiterAdded(PropertyChangeEvent pce) {
        
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
            jobs.add(job);
            joblist.addElement(job.toBriefString());
        }      
    }
    
    public ArrayList<Job> getJobs() {
        return jobs;
    }
    
    public void addJob(Job job) {
        jobs.add(job);
        companies.addCompany(job.company);
        titles.addTitle(job.title);
        locations.addLocation(job.loc);
        recruiters.addRecruiter(job.recruiter);
        for (int i = 0; i < job.langs.size(); i++) {
            languages.addLanguage(job.langs.get(i));
        }
        joblist.addElement(job.toBriefString());
    }
}
