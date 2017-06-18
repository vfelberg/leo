package leo;

public class StringUtils {
    public static String chop(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }
        if (str.endsWith("\r\n")) {
            return str.substring(0, str.length() - 2);

        }
        return str.substring(0, str.length() - 1);
    }

    public static String repeat(String str, int repeat) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static String repeat(String str, String separator, int repeat) {
        if (str == null) {
            return null;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < repeat; i++) {
            result.append(str);
            if (i < repeat - 1) {
                result.append(separator);
            }
        }
        return result.toString();

    }

    public static int compare(String str1, String  str2){
        if(str1.isEmpty()|| str2.isEmpty()) {
            return 0;
        }else if(str1.compareTo(str2)<0){
            return -1;
        } else {
            return 1;
        }
    }
}


