package jobhunter;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
            JPanel background = new JPanel();
            background.add(company);
            background.add(location);
            background.add(title);

            frame.getContentPane().add(background);
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
