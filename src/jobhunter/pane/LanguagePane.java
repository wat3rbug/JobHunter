package jobhunter.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jobhunter.data.Language;

/**
 * @author Douglas Gardiner
 * A Tabbed Pane used for displaying Language info to add to the main job hunt 
 * pane.
 */

public class LanguagePane extends TabPane implements ILanguagePane {

    private ArrayList<Language> languageListing;
    private Language temp;
    private IChangeListener delegate;

    public LanguagePane(IChangeListener delegate) {
        super("Languages");
        this.delegate = delegate;
        languageListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }
    
    /**
     * Returns the Language object that was added via this pane.  It is used by 
     * the delegate object.  See IChangeListener for implementation details.
     * @return The Language object that was added via this pane.
     */

    @Override
    public Language getLanguage() {
        return temp;
    }
    
    /**
     * Sets a delegate so that when changes occur to this pane, the delegate
     * is notified.  This uses the IChangeListener interface so that only 
     * classes that use this interface can participate.  The delegate is an 
     * optional object.
     * @param delegate The IChangeListener object that will be notified when a 
     * change occurs.
     */

    @Override
    public void setDelegate(IChangeListener delegate) {
        this.delegate = delegate;
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            temp = new Language(insertField.getText());
            languageListing.add(temp);
            addEntry(temp.toString());
            if (delegate != null) delegate.receivedUpdate(LanguagePane.this);
        }     
    }
}
