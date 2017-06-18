package leo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUtils {

    public static int indexOf(Object[] array, Object objectToFind) {
        if (array == null) {
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].equals(objectToFind)) {
                return i;
            }
        }
        return -1;
    }

    public static <T extends Comparable<T>> int binarySearch(T[] array, T objectToFind) {
        if (array == null || objectToFind == null) {
            return -1;
        }
        Arrays.sort(array);

        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid].equals(objectToFind)) {
                return mid;
            }

            if (array[mid].compareTo(objectToFind) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }


    public static <T> List<T> reverse(List<T> list) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            result.add(0, e);
        }
        return result;
    }

    public static int lastIndexOf(Object[] array, Object objectToFind) {
        if (array == null) {
            return -1;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i].equals(objectToFind)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean contains(Object[] array, Object objectToFind) {
        for (Object e : array) {
            if (e.equals(objectToFind)) {
                return true;
            }
        }
        return false;
    }


}
