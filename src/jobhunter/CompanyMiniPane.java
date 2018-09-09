package jobhunter;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 */
public class CompanyMiniPane extends MiniPane {

    private DefaultListModel<Company> listing;
    private JList<Company> companyListing;
    private JScrollPane scroller;
    
    public CompanyMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Companies"));
        listing = new DefaultListModel<Company>();
        companyListing = new JList<Company>(listing);
        scroller = new JScrollPane(companyListing);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(180, 120));
        this.add(scroller);
    }
    @Override
    public Object[] getListing() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
