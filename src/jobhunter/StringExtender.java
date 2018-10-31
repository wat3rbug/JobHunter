package jobhunter;

/**
 * @author Douglas Gardiner
 * This class has only one purpose, and that is to stringify booleans.  It is
 * used because I did some development in C# and missed String methods that 
 * would convert a boolean to Yes or No, and vice versa.
 */
public class StringExtender {

    /**
     * This method takes a String and returns true if the String is 'Yes' and
     * false if the String is 'No'.  The default value if false.
     * @param value The String to convert to a boolean value.
     * @return true or false, depending on the String value presented.
     */
    
    public static boolean toBooleanValue(String value) {
        if (value.equals("yes") || value.equals("Yes") || value.equals("YES")) {
            return true;
        } else return false;
    }
    
    /**
     * This method takes a boolean and returns 'Yes' if it is true and 'No' if
     * it is false.  
     * @param value The boolean value to convert to a String.
     * @return A String that is 'Yes' or 'No'.
     */
    
    public static String toYesNoString(boolean value) {
        return value ? "Yes" : "No";
    }
    
}
