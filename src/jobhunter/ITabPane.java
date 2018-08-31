package jobhunter;

/**
 * a simple interface so that the panes will have reusable actions, including
 * the company pane which could have more than 1 unique entry box.
 * @author Your Name <Douglas Gardiner>
 */
public interface ITabPane {
    
    /**
     * Used for adding an input entry like a check box for text-field. 
     * @param name The name of the parameter.
     * @param isCheckBox Determines if input is a check-box.
     */
    void addEntry(String name, boolean isCheckBox);
}
