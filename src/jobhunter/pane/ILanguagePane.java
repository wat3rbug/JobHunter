package jobhunter.pane;

import jobhunter.data.Language;

/**
 * @author Douglas Gardiner
 * An interface for the Language Pane.  
 */

public interface ILanguagePane extends IPaneObserver{
    
    /**
     * Returns the Language object from the object that implements this 
     * interface.
     * @return A Language object.
     */
    
     public Language getLanguage();
}
