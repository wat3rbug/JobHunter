package jobhunter.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jobhunter.data.Language;

/**
 * @author Douglas Gardiner
 */
public class LanguagePane extends TabPane implements ILanguagePane {

    private ArrayList<Language> languageListing;
    private Language temp;
    private ChangeListener delegate;

    public LanguagePane(ChangeListener delegate) {
        super("Languages");
        this.delegate = delegate;
        languageListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }

    @Override
    public Language getLanguage() {
        return temp;
    }

    @Override
    public void setDelegate(ChangeListener delegate) {
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
