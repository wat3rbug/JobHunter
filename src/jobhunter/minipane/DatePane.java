package jobhunter.minipane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import jobhunter.pane.IChangeListener;
import jobhunter.pane.IDatePane;

/**
 * @author Douglas Gardiner
 */
public class DatePane extends JPanel implements IDatePane {
    
    private static boolean PREVIOUS_DATE = false;
    private static boolean NEXT_DATE = true;

    IChangeListener delegate;
    JButton previousBtn;
    JButton nextBtn;
    JButton todayBtn;
    JButton allBtn;
    Date selectedDate = Calendar.getInstance().getTime();
    SimpleDateFormat filterForDate =new SimpleDateFormat("dd MMM yyyy");
    String displayedDate = filterForDate.format(selectedDate);
    JLabel selectedDateLbl;
    
    public DatePane(IChangeListener delegate) {
        this.delegate = delegate;
        this.setBorder(BorderFactory.createTitledBorder("Filters"));
        //selectedDate = new Date();
        previousBtn = new JButton("Prev");
        nextBtn = new JButton("Next");
        todayBtn = new JButton("Today");
        allBtn = new JButton("All");
        JPanel top = new JPanel();
        previousBtn.addActionListener(new PrevDay());
        nextBtn.addActionListener(new NextDay());
        todayBtn.addActionListener(new TodayDay());
        allBtn.addActionListener(new AllDays());
        
        top.add(previousBtn);
        top.add(todayBtn);
        top.add(nextBtn);
        JPanel bottom = new JPanel();
        JPanel displayDate = new JPanel();
        JLabel dateDisplay = new JLabel("Date:");
        selectedDateLbl = new JLabel(displayedDate);
        displayDate.add(dateDisplay);
        displayDate.add(selectedDateLbl);
        bottom.add(allBtn);
        this.setLayout(new GridLayout(3, 1));
        this.add(top);
        this.add(displayDate);
        this.add(bottom);      
    }
    
    @Override
    public void setDelegate(IChangeListener delegate) {
        this.delegate = delegate;
    }
    
    protected class AllDays implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            selectedDate = null;
            Calendar cal = Calendar.getInstance();
            selectedDateLbl.setText(filterForDate.format(cal.getTime()));
            if (delegate !=null) delegate.receivedUpdate(DatePane.this);
        }
    }
    
    protected class NextDay implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            Calendar cal = getDate();
            cal.roll(Calendar.MONTH, NEXT_DATE);
            if (cal.get(Calendar.MONTH) == 0) cal.roll(Calendar.YEAR, NEXT_DATE);
            selectedDateLbl.setText(filterForDate.format(cal.getTime()));
            selectedDate = cal.getTime();
            if (delegate !=null) delegate.receivedUpdate(DatePane.this);
        }
    }
    
    protected class TodayDay implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            Calendar cal = Calendar.getInstance();
            selectedDateLbl.setText(filterForDate.format(cal.getTime()));
            selectedDate = cal.getTime();
            if (delegate !=null) delegate.receivedUpdate(DatePane.this);
        }
        
    }
    
    protected class PrevDay implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent ae) {
            
            Calendar cal = getDate();
            if (cal.get(Calendar.MONTH) == 0) cal.roll(Calendar.YEAR, PREVIOUS_DATE);
            cal.roll(Calendar.MONTH, PREVIOUS_DATE);
            selectedDateLbl.setText(filterForDate.format(cal.getTime()));
            selectedDate = cal.getTime();
            if (delegate !=null) delegate.receivedUpdate(DatePane.this);
        }
    }
    
    private Calendar getDate() {
        
        String currentDate = selectedDateLbl.getText();
        int day = new Integer(currentDate.substring(0, currentDate.indexOf(' ')));
        String monthRaw = currentDate.substring(currentDate.indexOf(' ') + 1);
        int month = DatePane.parseMonth(monthRaw.substring(0, monthRaw.indexOf(' ')));
        String yearRaw = monthRaw.substring(monthRaw.indexOf(' ') + 1);
        int year = new Integer(yearRaw);
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, day);
        return cal;
    }
    
    private static int parseMonth(String monInput) {
        
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul",
                "Aug", "Sep", "Oct", "Nov", "Dec"};
        for (int i = 0; i < months.length; i++) {
            if (monInput.equals(months[i])) return i;
        }
        return 0;
    }
      
    @Override
    public Date getSelectedDate() {
        return selectedDate;
    }
}
