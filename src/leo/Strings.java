package leo;

import com.sun.istack.internal.Nullable;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Strings {

    @Nullable
    public static String emptyToNull(@Nullable String string) {
        if (string != null && !string.isEmpty()) {
            return string;
        }
        return null;
    }

    public static boolean isNullOrEmpty(@Nullable String string) {
        if (string != null && !string.isEmpty()) {
            return false;
        }
        return true;
    }

    public static String nullToEmpty(@Nullable String string) {
        if (string != null && !string.isEmpty()) {
            return string;
        }
        return "";
    }

    public static String padStart(String string, int minLength, char padChar) {
        if (string.length() >= minLength) {
            return string;
        }
        StringBuilder sb = new StringBuilder(minLength);
        for (int i = string.length(); i < minLength; i++) {
            sb.append(padChar);
        }

        sb.append(string);
        return sb.toString();
    }

    public static String padEnd(String string, int minLength, char padChar) {
        if (string.length() >= minLength) {
            return string;
        }

        StringBuilder sb = new StringBuilder(minLength);
        sb.append(string);
        for (int i = string.length(); i < minLength; i++) {
            sb.append(padChar);
        }

        return sb.toString();
    }

    public static String mapToString(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(entry);

        }
        return sb.toString();

    }

    /**
     * Input has the form: key1=value1&key2=value2.
     */
    public static Map<String, List<String>> parseQueryString(String s) {
        if (s == null || s.isEmpty()) {
            return new HashMap<>();
        }

        String[] keyValuePairs = s.split("&");
        Map<String, List<String>> map = new HashMap<>();

        for (String pair : keyValuePairs) {
            if (pair.contains("=")) {
                String[] entry = pair.split("=");
                String key = entry[0].trim();

                String value;
                try {
                    value = URLDecoder.decode(entry[1].trim(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }

                List<String> values = map.get(key);
                if (values == null) {
                    values = new ArrayList<>();
                    map.put(key, values);
                }
                values.add(value);

            } else {
                throw new IllegalArgumentException(pair + " doesn't contain =");
            }

        }
        return map;
    }

}
