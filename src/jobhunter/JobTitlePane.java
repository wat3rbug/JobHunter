package jobhunter;

import java.util.ArrayList;

/**
 * @author Douglas Gardiner
 */
public class JobTitlePane extends TabPane {

    public JobTitlePane() {
        super("Job Title");
    }
    
    @Override
    public void addEntry(String text, boolean isCheckBox) {
        
    }

    @Override
    public void addObjectList(ArrayList listing) {
        super.objectListing = listing;  
    }
}
