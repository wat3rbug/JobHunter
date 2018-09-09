package jobhunter.minipane;

import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * @author Douglas Gardiner
 */
public abstract class MiniPane extends JPanel {

    private JList listing;

    public abstract Object[] getListing();
}
