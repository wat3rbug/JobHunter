package jobhunter.minipane;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.text.Position;
import jobhunter.data.Language;

/**
 * @author Douglas Gardiner
 * A basic mini display which is used on the JobHunt Pane.  It displays a brief
 * synopsis of the language as it exists as an option.
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
    
    /**
     * Adds a Language object to the listing so that it can be displayed.
     * @param title The Language object that is to be added to the display.
     */
    
    public void addLanguage(Language title) {
        int found = -1;
        int max = listing.getSize();
        for (int i = 0; i < max; i++) {
            if (listing.get(i).language.toLowerCase().equals(
                    title.language.toLowerCase())) {
                found = i;
            }
        }
        if (found == -1) {
            listing.addElement(title);
        }
    }
    
    /**
     * Returns the selected Language object/s from the pane.  Since more than 
     * one language can be selected and ArrayList is returned
     * @return The Language objects that is derived from the listing.
     */
    
    public ArrayList<Language> getSelected() {
        int[] indexes = langListing.getSelectedIndices();
        ArrayList<Language> result = new ArrayList<>();
        for(int index : indexes) result.add(langListing.getModel().getElementAt(index));
        return result;
    }
}
