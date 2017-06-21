package leo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListUtils {
    public static List<Integer> filterEven(List<Integer> list) {
        return filter(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i % 2 == 0;
            }
        });
    }

    public static List<Integer> filterUneven(List<Integer> list) {
        return filter(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i % 2 != 0;
            }
        });
    }

    public static List<Integer> filterGreaterThanOrEqual(List<Integer> list, int boundary) {
        return filter(list, new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                return i >= boundary;
            }
        });
    }

    public static List<Integer> filterLessThanOrEqual(List<Integer> list, int boundary) {
        return filter(list, new LessThanOrEqualPredicate(boundary));
    }

    public static List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        for (int i : list) {
            if (predicate.test(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
