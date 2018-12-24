package jobhunter.minipane;

import jobhunter.data.Company;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 * A basic mini display which is used on the JobHunt Pane.  It displays a brief
 * synopsis of the company as it exists as an option.
 */
public class CompanyMiniPane extends MiniPane {

    private DefaultListModel<Company> listing;
    private JList<Company> companyListing;
    private JScrollPane scroller;
    
    public CompanyMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Companies"));
        listing = new DefaultListModel();
        companyListing = new JList(listing);
        scroller = new JScrollPane(companyListing);
        scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(180, 120));
        this.add(scroller);
    }
    
    /**
     * Adds a Company object to the listing so that it can be displayed.
     * @param company The Company object that is to be added to the display.
     */
    
    public void addCompany(Company company) {
                
        int found = -1;
        int max = listing.getSize();
        for (int i = 0; i < max; i++) {
            if (listing.get(i).companyName.toLowerCase().equals(
                    company.companyName.toLowerCase())) {
                found = i;
            }
        }
        if (found == -1) {
            listing.addElement(company);
        }
    }
    
    /**
     * Returns the selected Company object from the pane.  NOTE: Only one 
     * company can be selected. 
     * @return The Company object that is derived from the listing.
     */
    
    public Company getSelected() {
        return companyListing.getSelectedValue();
    }
}
