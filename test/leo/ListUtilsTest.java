package leo;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.function.Predicate;

import static leo.ListUtils.filterEven;
import static leo.ListUtils.filterGreaterThanOrEqual;

public class ListUtilsTest {
    @Test
    public void testFilterEven() {
        assertEquals(
                ImmutableList.of(-10, 8, 0, 4, 500, -10, -1000),
                filterEven(ImmutableList.of(1, 3, -10, 7, 8, 0, -8, 4, 9, 1001, 500, -10, -1000)));
    }

    @Test
    public void testFilterUneven() {
        assertEquals(
                ImmutableList.of(1, 3, 7, 9, 1001),
                filterUneven(ImmutableList.of(1, 3, -10, 7, 8, 0, -8, 4, 9, 1001, 500, -10, -1000)));
    }

    @Test
    public void testFilterGreaterThanOrEqual() {
        assertEquals(
                ImmutableList.of(1, 3, 7, 8, 0, 4, 9, 1001, 500),
                filterGreaterThanOrEqual(ImmutableList.of(1, 3, -10, 7, 8, 0, -8, 4, 9, 1001, 500, -10, -1000), 0));
    }

    @Test
    public void testFilterLessThanOrEqual() {
        assertEquals(
                ImmutableList.of(-10, 0, -8, -10, -1000),
                filterGreaterThanOrEqual(ImmutableList.of(1, 3, -10, 7, 8, 0, -8, 4, 9, 1001, 500, -10, -1000), 0));
    }

    @Test
    public void testFilter() {
        assertEquals(
                ImmutableList.of(1, 3, 7, 8, 0, 4, 9),
                filter(ImmutableList.of(1, 3, -10, 7, 8, 0, -8, 4, 9, 1001, 500, -10, -1000), new Predicate<Integer>(
        @Override
        public boolean test(Integer i){
            return i >= 0 && i <= 10;
        }
        )));
    }
}
