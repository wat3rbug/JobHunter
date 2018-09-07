package jobhunter;

/**
 * @author Douglas Gardiner
 */
public class StringExtender {

    public static boolean toBooleanValue(String value) {
        if (value.equals("yes") || value.equals("Yes") || value.equals("YES")) {
            return true;
        } else return false;
    }
    
    public static String toYesNoString(boolean value) {
        return value ? "Yes" : "No";
    }
    
}
