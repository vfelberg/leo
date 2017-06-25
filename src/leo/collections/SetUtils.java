package leo.collections;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
    /**
     * Returns all elements which are in set1 but not in set2.
     */
    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>();
        for (T e : set1) {
            if (!set2.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Returns elements from set1 combined with elements from set2.
     */
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }

    /**
     * Returns elements which are contained both in set1 and set2.
     */
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>();
        for (T e : set1) {
            if (set2.contains(e)) {
                result.add(e);
            }
        }
        return result;
    }

    /**
     * Returns elements which are contained either in set1 and set2 but not in both.
     */
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        // symmetric difference = union - intersection (- means difference)
        Set<T> union = union(set1, set2);
        Set<T> intersection = intersection(set1, set2);
        return difference(union, intersection);
    }

    private SetUtils() {}
}
