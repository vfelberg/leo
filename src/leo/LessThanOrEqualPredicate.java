package leo;

import java.util.function.Predicate;

public class LessThanOrEqualPredicate implements Predicate<Integer> {
    private final Integer boundary;

    public LessThanOrEqualPredicate(Integer boundary) {
        this.boundary = boundary;
    }

    @Override
    public boolean test(Integer i) {
        return i <= boundary;
    }
}
