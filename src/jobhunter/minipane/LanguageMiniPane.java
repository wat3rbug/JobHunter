package jobhunter.minipane;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import jobhunter.data.Language;

/**
 * @author Douglas Gardiner
 */
public class LanguageMiniPane extends MiniPane {

    private DefaultListModel<Language> listing;
    private JList<Language> langListing;
    private JScrollPane scroller;
    
    public LanguageMiniPane() {
        this.setBorder(BorderFactory.createTitledBorder("Languages"));
        listing = new DefaultListModel<Language>();
        langListing = new JList<Language>(listing);
        scroller = new JScrollPane(langListing);
        langListing.setSelectionMode(ListSelectionModel
                .MULTIPLE_INTERVAL_SELECTION);
        scroller.setVerticalScrollBarPolicy(JScrollPane
                .VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setPreferredSize(new Dimension(180, 120));
        this.add(scroller);
    }
    
    public void addLanguage(Language title) {
        if (!listing.contains(title.toString())) listing.addElement(title);
    }
    
    public ArrayList<Language> getSelected() {
        int[] indexes = langListing.getSelectedIndices();
        ArrayList<Language> result = new ArrayList<>();
        for(int index : indexes) result.add(langListing.getModel().getElementAt(index));
        return result;
    }
}
