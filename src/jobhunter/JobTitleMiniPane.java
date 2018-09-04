package jobhunter;

import javax.swing.BorderFactory;

/**
 * @author Douglas Gardiner
 */
public class JobTitleMiniPane extends MiniPane{

    public JobTitleMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Job Titles"));
    }
    @Override
    public Object[] getListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
