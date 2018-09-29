package jobhunter;

import com.apple.eawt.AppEvent;
import jobhunter.pane.JobHuntPane;
import jobhunter.pane.CompanyPane;
import jobhunter.pane.JobTitlePane;
import jobhunter.pane.LocationPane;
import jobhunter.data.Job;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import com.apple.eawt.QuitHandler;
import com.apple.eawt.Application;
import com.apple.eawt.QuitResponse;
import jobhunter.data.Company;
import jobhunter.data.JobTitle;
import jobhunter.data.Language;
import jobhunter.data.Location;
import jobhunter.pane.IChangeListener;
import jobhunter.pane.ICompanyPane;
import jobhunter.pane.IJobTitlePane;
import jobhunter.pane.ILanguagePane;
import jobhunter.pane.ILocationPane;
import jobhunter.pane.IRecruiterPane;
import jobhunter.pane.LanguagePane;
import jobhunter.pane.RecruiterPane;

/**
 * @author Douglas Gardiner
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class JobHunt implements IChangeListener{
    
    private CompanyPane company;
    private LocationPane location;
    private JobTitlePane title;
    private RecruiterPane recruiter;
    private JobHuntPane totals;
    private LanguagePane languages;
    public String filename;
    
    public JobHunt() {
        company = new CompanyPane(this);
        location = new LocationPane(this);
        title = new JobTitlePane(this);
        recruiter = new RecruiterPane(this);
        languages = new LanguagePane(this);
        totals = new JobHuntPane();
     
        JFrame frame = new JFrame("JobHunter");
        JTabbedPane background = new JTabbedPane();
        background.addTab("Job Title", null, title);
        background.addTab("Languages", null, languages);
        background.addTab("Company", null, company);
        background.addTab("Location", null, location);    
        background.addTab("Job Sites", null, recruiter);
        background.addTab("Jobs", null, totals);
        background.setPreferredSize(new Dimension (800, 550));
        background.setMinimumSize(new Dimension (800, 550));
        JPanel overall = new JPanel();
        FlowLayout flow = new FlowLayout();
        overall.setLayout(flow);
        overall.add(background);
        frame.getContentPane().add(background);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        frame.addWindowListener(new CloseUpShop());
        Application macApp = Application.getApplication();
        macApp.setQuitHandler(new CloseShopByHotKey());
    }

    @Override
    public void receivedUpdate(ICompanyPane pane) {
        totals.addCompany(pane.getCompany());
    }

    @Override
    public void receivedUpdate(IJobTitlePane pane) {
        totals.addTitle(pane.getJobTitle());
    }

    @Override
    public void receivedUpdate(ILanguagePane pane) {
        totals.addLanguage(pane.getLanguage());
    }

    @Override
    public void receivedUpdate(ILocationPane pane) {
        totals.addLoc(pane.getLoc());
    }

    @Override
    public void receivedUpdate(IRecruiterPane pane) {
        totals.addRecruiter(pane.getRecruiter());
    }
    
    private class CloseShopByHotKey implements QuitHandler {
        
        @Override
        public void handleQuitRequestWith(AppEvent.QuitEvent qe, 
                final QuitResponse qr) {
            
            JobHunt.this.SaveAndQuit();
            qr.performQuit();
        }
    }
    
    private void SaveAndQuit() {
        if (filename != null) FileOperations.write(filename, getJobs());
        else FileOperations.write(getJobs());
    }

    
    private class CloseUpShop extends WindowAdapter {
        
        @Override
        public void windowClosing(WindowEvent e) {
            JobHunt.this.SaveAndQuit();
            e.getWindow().dispose();
        }
     }
    
    private ArrayList<Job> getJobs() {
        return totals.getJobs();
    }
    
    public void use(ArrayList<Job> jobs) {
        
        for (Job temp : jobs) {
            if (temp.loc != null) location.addEntry(temp.loc.toString());
            if (temp.title != null) title.addEntry(temp.title.toString());
            if (temp.company != null) company.addEntry(temp.company.toString());
            if (temp.recruiter != null) recruiter.addEntry(temp.recruiter
                    .toString());
            if (temp.langs != null || temp.langs.size() != 0) {
                for (Language lang : temp.langs) {
                    languages.addEntry(lang.toString());
                }
            }
            totals.addJob(temp);
        }        
    }
    
    /**
     * @param args the command line argument uses a single file name.  If none
     * is used then the default 'config.xml' will be used.
     * 
     */
    
    public static void main(String[] args) {
        ArrayList<Job> jobs; 
        JobHunt main = new JobHunt();
        if (args.length == 1) {
            main.filename = args[0];
            jobs = FileOperations.read(args[0]);
        } else {
            jobs = FileOperations.read();
        }           
        main.use(jobs);
    }
    
    
}
