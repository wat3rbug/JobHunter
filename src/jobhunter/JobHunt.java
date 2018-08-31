package jobhunter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * @author Douglas Gardiner
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class JobHunt {

    public JobHunt() {
            CompanyPane company = new CompanyPane();
            LocationPane location = new LocationPane();
            JobTitlePane title = new JobTitlePane();
            JFrame frame = new JFrame("JobHunter");
            JTabbedPane background = new JTabbedPane();
            background.addTab("Company", null, company);
            background.addTab("Location", null, location);
            background.addTab("Job Title", null, title);
            background.setPreferredSize(new Dimension (800, 300));
            background.setMinimumSize(new Dimension (800, 300));
            JPanel overall = new JPanel();
            FlowLayout flow = new FlowLayout();
            overall.setLayout(flow);
            overall.add(background);
            frame.getContentPane().add(background);
            frame.pack();
            frame.setVisible(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
    }
    
    /**
     * @param args the command line arguments which are not used.
     * 
     */
    
    public static void main(String[] args) {
        JobHunt main = new JobHunt();
    }
    
}
