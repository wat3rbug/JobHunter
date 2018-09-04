package jobhunter;

import javax.swing.BorderFactory;

/**
 * @author Douglas Gardiner
 */
public class CompanyMiniPane extends MiniPane {

    public CompanyMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Companies"));
    }
    @Override
    public Object[] getListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
