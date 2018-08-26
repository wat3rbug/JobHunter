package jobhunter;
/**
 * @author douglas
 * Basic data object that stores job title information since the 
 * same job title can exist for more than 1 company
 */

public class JobTitle {

    private static int lastId = 1;
    
    private String jobTitle;
    private int id;

    public JobTitle(String title) {
            this.jobTitle = title;
            this.id = lastId++;
    }
}