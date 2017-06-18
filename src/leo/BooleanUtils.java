package leo;

public class BooleanUtils {
    public static String toStringYesNo(boolean bool) {
        return toString(bool, "yes", "no");
    }



    public static String toString(boolean bool, String trueString, String falseString) {
        if (bool) {
            return trueString;
        } else {
            return falseString;
        }
    }

    public static boolean and(boolean... array) {
        for (boolean bool : array) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }

    public static boolean or(boolean... array) {
        for (boolean bool : array) {
            if (bool) {
                return true;
            }
        }
        return false;
    }

}
