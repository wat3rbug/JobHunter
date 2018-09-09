package jobhunter.data;

import jobhunter.StringExtender;

/**
 * @author douglas
 * Basic data object for the application.  Store relevant information for 
 * a company.
 */

public class Company {

    private static int lastId = 1;

    private String companyName;
    private boolean isStaffing;
    private int id;

    public Company(String name) {
            companyName = name;
            isStaffing = false;
            id = lastId++;
    }
    
    public Company(String name, String isStaffing) {
        this(name);
        this.isStaffing = StringExtender.toBooleanValue(isStaffing);     
    }
    
    @Override
    public String toString() {
        if (isStaffing == true) return companyName + ", staffing";
        else return companyName;
        
        // this should easily be written as but its not working with is IDE
        // return companyName + (isStaffing ? ", staffing" : " ");
    }
}
