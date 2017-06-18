package leo;

import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.*;


public class StringsTest {
    @Test
    public void testEmptyToNull() {
        assertEquals(null, Strings.emptyToNull(null));
        assertEquals(null, Strings.emptyToNull(""));
        assertEquals("a", Strings.emptyToNull("a"));
        assertEquals("aa", Strings.emptyToNull("aa"));
    }

    @Test
    public void testEmptyOrNull() {
        assertTrue(Strings.isNullOrEmpty(null));
        assertTrue(Strings.isNullOrEmpty(""));
        assertFalse(Strings.isNullOrEmpty(" "));
        assertFalse(Strings.isNullOrEmpty("a"));

    }

    @Test
    public void testNullToEmpty() {
        assertEquals("", Strings.nullToEmpty(null));
        assertEquals("", Strings.nullToEmpty(""));
        assertEquals(" ", Strings.nullToEmpty(" "));
        assertEquals("a", Strings.nullToEmpty("a"));
    }

    @Test
    public void testPadStart() {
        assertEquals("007", Strings.padStart("7", 3, '0'));
        assertEquals("2010", Strings.padStart("2010", 3, '0'));
    }

    @Test
    public void testPadEnd() {
        assertEquals("4.000", Strings.padEnd("4.", 5, '0'));
        assertEquals("2010", Strings.padEnd("2010", 3, '!'));
    }

    @Test
    public void testMapToString() {
        assertEquals("", Strings.mapToString(null));

        Map<String, Object> map = new HashMap<>();
        // empty map
        assertEquals("", Strings.mapToString(map));

        map.put("a", 1);
        map.put("b", 2);

        // non-empty map
        assertEquals("a=1&b=2", Strings.mapToString(map));
    }

    @Test
    public void testStringToMap() {
        assertEquals(new HashMap<String, List<String>>(), Strings.parseQueryString(null));
        assertEquals(new HashMap<String, List<String>>(), Strings.parseQueryString(""));

        Map<String, List<String>> map = new HashMap<>();
        map.put("a", singletonList("1"));
        assertEquals(map, Strings.parseQueryString("a=1"));

        map = new HashMap<>();
        map.put("a", singletonList("1"));
        map.put("b", singletonList("2"));
        assertEquals(map, Strings.parseQueryString("a=1&b=2"));

        try {
            assertEquals(map, Strings.parseQueryString("a"));
            throw new AssertionError("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // expected
        }
        try {
            assertEquals(map, Strings.parseQueryString("a&b=2"));
            throw new AssertionError("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // expected
        }

        map = new HashMap<>();
        map.put("a", asList("1", "3"));
        map.put("b", singletonList("2"));
        map.put("c", asList("2", "4", "5"));
        assertEquals(map, Strings.parseQueryString("c=2&a=1&b=2&c=4&a=3&c=5"));

        map = new HashMap<>();
        map.put("url", asList("http://www.google.com"));
        assertEquals(map, Strings.parseQueryString("url=http%3A%2F%2Fwww.google.com"));

        // url decode maven

    }
}

