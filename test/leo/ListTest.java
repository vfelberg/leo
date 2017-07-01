package leo;

import com.google.common.collect.ImmutableList;
import leo.collections.CustomLinkedList;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ListTest {
    @Test
    public void testListProperties() {
        List<String> list = new CustomLinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertFalse(list.contains("a"));
        assertFalse(list.contains("b"));
        assertArrayEquals(new String[]{}, list.toArray());

        list.add("a");
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
        assertEquals("a", list.get(0));
        assertTrue(list.contains("a"));
        assertFalse(list.contains("b"));
        assertArrayEquals(new String[]{"a"}, list.toArray());

        list.add("a");
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        assertEquals("a", list.get(0));
        assertEquals("a", list.get(1));
        assertTrue(list.contains("a"));
        assertFalse(list.contains("b"));
        assertArrayEquals(new String[]{"a", "a"}, list.toArray());

        list.add("b");
        assertEquals(3, list.size());
        assertFalse(list.isEmpty());
        assertEquals("a", list.get(0));
        assertEquals("a", list.get(1));
        assertEquals("b", list.get(2));
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertArrayEquals(new String[]{"a", "a", "b"}, list.toArray());

        list.add("a");
        assertEquals(4, list.size());
        assertFalse(list.isEmpty());
        assertEquals("a", list.get(0));
        assertEquals("a", list.get(1));
        assertEquals("b", list.get(2));
        assertEquals("a", list.get(3));
        assertTrue(list.contains("a"));
        assertTrue(list.contains("b"));
        assertArrayEquals(new String[]{"a", "a", "b", "a"}, list.toArray());

        /*
        assertEquals(ImmutableList.of("a", "a", "b", "a"), list);

        Collections.sort(list);
        assertEquals(ImmutableList.of("a", "a", "a", "b"), list);
        */
    }

    @Test
    public void testClear() {
        List<String> list = new CustomLinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertArrayEquals(new String[]{}, list.toArray());

        list.add("a");
        list.add("b");
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
        assertArrayEquals(new String[]{"a", "b"}, list.toArray());

        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
        assertArrayEquals(new String[]{}, list.toArray());
    }

    @Test
    public void testAddAll() {
        List<String> list = new CustomLinkedList<>();
        assertArrayEquals(new String[]{}, list.toArray());

        assertFalse(list.addAll(Collections.<String>emptyList()));

        assertTrue(list.addAll(ImmutableList.of("a", "b", "a", "c")));
        assertArrayEquals(new String[]{"a", "b", "a", "c"}, list.toArray());

        assertTrue(list.addAll(ImmutableList.of("d", "e", "a", "c")));
        assertArrayEquals(new String[]{"a", "b", "a", "c", "d", "e", "a", "c"}, list.toArray());
    }

    @Test
    public void testContainsAll() {
        List<String> list = new CustomLinkedList<>();
        assertTrue(list.containsAll(ImmutableList.of()));
        assertFalse(list.containsAll(ImmutableList.of("a")));

        list.add("a");
        list.add("b");
        assertTrue(list.containsAll(ImmutableList.of("a")));
        assertTrue(list.containsAll(ImmutableList.of("b")));
        assertTrue(list.containsAll(ImmutableList.of("a", "b")));
        assertFalse(list.containsAll(ImmutableList.of("b", "c")));
    }

    @Test
    public void testRemove() {
        List<String> list = new CustomLinkedList<>();
        assertFalse(list.remove("a"));
        assertArrayEquals(new String[]{}, list.toArray());

        list.add("a");
        assertFalse(list.remove("b"));
        assertTrue(list.remove("a"));
        assertArrayEquals(new String[]{}, list.toArray());

        list.add("a");
        list.add("b");
        assertFalse(list.remove("c"));
        assertTrue(list.remove("b"));
        assertArrayEquals(new String[]{"a"}, list.toArray());

        list.add("b");
        list.add("c");
        assertTrue(list.remove("b"));
        assertArrayEquals(new String[]{"a", "c"}, list.toArray());
    }

    @Test
    public void testRemoveAll(){
        List<String> list = new CustomLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        assertTrue(list.removeAll(ImmutableList.of("a", "b")));
        assertArrayEquals(new String[]{"c"}, list.toArray());

        assertFalse(list.removeAll(ImmutableList.of("d", "e")));
        assertArrayEquals(new String[]{"c"}, list.toArray());
    }

    @Test
    public void testIndexOf() {
        List<String> list = new CustomLinkedList<>();
        assertEquals(-1, list.indexOf("a"));

        list.add("a");
        list.add("b");
        assertEquals(0, list.indexOf("a"));
        assertEquals(1, list.indexOf("b"));

    }
}
