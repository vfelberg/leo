package leo.collections;

import java.util.HashSet;
import java.util.Set;

public class SetUtils {
    /**
     * Returns all elements which are in set1 but not in set2.
     */
    public static <T> Set<T> difference(Set<T> set1, Set<T> set2) {
        Set result = new HashSet<>();

        for (T e : set1) {
            result.add(e);
            for (T f : set2) {
                if (f.equals(e)) {
                    result.remove(f);
                }
            }
        }
        return result;
    }
}
