package jobhunter.data;

import jobhunter.data.Company;
import java.util.Date;

/**
 * Basic data class for the application
 * @author Douglas Gardiner
 */
public class Job {

    public JobTitle title;
    public Location loc;
    public Company company;
    public Date date;
    public boolean hadInterview;
}
