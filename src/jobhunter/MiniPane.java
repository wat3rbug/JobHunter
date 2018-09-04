package jobhunter;

import javax.swing.JList;
import javax.swing.JPanel;

/**
 * @author Douglas Gardiner
 */
public abstract class MiniPane extends JPanel {

    private JList listing;
    
    public abstract Object[] getListing();
}
