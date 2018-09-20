package jobhunter.pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import jobhunter.data.Language;

/**
 * @author Douglas Gardiner
 */
public class LanguagePane extends TabPane {

    private ArrayList<Language> languageListing;

    public LanguagePane() {
        super("Languages");
        languageListing = new ArrayList();
        adder.addActionListener(new AddListener());
    }
    
    protected class AddListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Language temp = new Language(insertField.getText());
            languageListing.add(temp);
            addEntry(temp.toString());
        }     
    }
}
