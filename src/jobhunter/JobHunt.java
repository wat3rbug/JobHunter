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
import jobhunter.data.Location;

/**
 * @author Douglas Gardiner
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class JobHunt {
    
    private CompanyPane company;
    private LocationPane location;
    private JobTitlePane title;
    private JobHuntPane totals;
    public String filename;
    
    public JobHunt() {
        company = new CompanyPane();
        location = new LocationPane();
        title = new JobTitlePane();
        totals = new JobHuntPane(this);
        JFrame frame = new JFrame("JobHunter");
        JTabbedPane background = new JTabbedPane();
        background.addTab("Company", null, company);
        background.addTab("Location", null, location);
        background.addTab("Job Title", null, title);
        background.addTab("Jobs", null, totals);
        background.setPreferredSize(new Dimension (800, 400));
        background.setMinimumSize(new Dimension (800, 400));
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
    
    private class CloseShopByHotKey implements QuitHandler {
        
        @Override
        public void handleQuitRequestWith(AppEvent.QuitEvent qe, 
                final QuitResponse qr) {
            
            JobHunt.this.SaveAndQuit();
            qr.performQuit();
        }
    }
    
    private void SaveAndQuit() {
//        if (filename != null) FileOperations.write(filename, getJobs());
//        else FileOperations.write(getJobs());
    }

    
    private class CloseUpShop extends WindowAdapter {
        
        @Override
        public void windowClosing(WindowEvent e) {
            JobHunt.this.SaveAndQuit();
            e.getWindow().dispose();
        }
     }
    
    private ArrayList<Job> getJobs() {
        // not done
        return new ArrayList<Job>();
    }
    
    public void use(ArrayList<Job> jobs) {
        
        for(int i = 0; i < jobs.size(); i++) {
            Job temp = jobs.get(i);
            location.addEntry(temp.loc.toString());
            title.addEntry(temp.title.toString());
            company.addEntry(temp.company.toString());
            totals.addJob(temp);
        }
        //company.add(companies);
        
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
