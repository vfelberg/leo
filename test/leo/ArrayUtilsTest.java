package leo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ArrayUtilsTest {
    @Test
    public void testIndexOf() {

        assertEquals(1, ArrayUtils.indexOf(new String[]{"1", "2", "3", "4"}, "2"));
        assertEquals(2, ArrayUtils.indexOf(new String[]{"1", "2", "3", "2"}, "3"));
        assertEquals(-1, ArrayUtils.indexOf(new String[]{"1", "2", "3", "2"}, "4"));
        assertEquals(-1, ArrayUtils.indexOf(null, "2"));
        assertEquals(-1, ArrayUtils.indexOf(new String[]{"1", "2", "3", "2"}, null));
    }

    @Test
    public void testBinarySearch() {

        assertEquals(1, ArrayUtils.binarySearch(new String[]{"1", "2", "3", "4"}, "2"));
        assertEquals(3, ArrayUtils.binarySearch(new String[]{"1", "2", "2", "3"}, "3"));
        assertEquals(0, ArrayUtils.binarySearch(new String[]{"1", "2", "3", "4", "5"}, "1"));
        assertEquals(-1, ArrayUtils.binarySearch(new String[]{"1", "2", "2", "3"}, "4"));
        assertEquals(-1, ArrayUtils.binarySearch(null, "2"));
        assertEquals(-1, ArrayUtils.binarySearch(new String[]{"1", "2", "2", "3"}, null));
    }

    @Test
    public void testReverse() {

        List<String> actual2 = new ArrayList<>();
        actual2.add("a");
        actual2.add("b");
        actual2.add("c");

        List<String> expected2 = new ArrayList<>();
        expected2.add("c");
        expected2.add("b");
        expected2.add("a");

        assertEquals(expected2, ArrayUtils.reverse(actual2));

        List<String> original = new ArrayList<>();
        original.add("a");
        original.add("b");
        original.add("c");

        List<String> actual = new ArrayList<>();
        actual.add("a");
        actual.add("b");
        actual.add("c");

        List<String> expected = new ArrayList<>();
        expected.add("c");
        expected.add("b");
        expected.add("a");

        assertEquals(expected, ArrayUtils.reverse(actual));

    }

    @Test
    public void testLastIndexOf() {

        assertEquals(3, ArrayUtils.lastIndexOf(new String[]{"1", "2", "3", "2"}, "2"));
        assertEquals(-1, ArrayUtils.lastIndexOf(null, "2"));
        assertEquals(-1, ArrayUtils.lastIndexOf(new String[]{"1", "2", "3", "2"}, null));
    }

    @Test
    public void testContains() {
        assertEquals(true, ArrayUtils.contains(new String[]{"1", "2", "3", "2"}, "3"));
    }


}
