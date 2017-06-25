package leo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CaseInsensitiveMapTest {
    @Test
    public void testMapProperties() {
        Map<String, Integer> map = new CaseInsensitiveMap<>();
        assertEquals(0, map.size());

        map.put("a", 1);
        assertEquals(1, map.size());
        assertEquals(Integer.valueOf(1), map.get("a"));
        assertEquals(Integer.valueOf(1), map.get("A"));

        map.put("A", 2);
        assertEquals(1, map.size());
        assertEquals(Integer.valueOf(2), map.get("a"));
        assertEquals(Integer.valueOf(2), map.get("A"));

        map.put("b", 3);
        assertEquals(2, map.size());
        assertEquals(Integer.valueOf(2), map.get("a"));
        assertEquals(Integer.valueOf(2), map.get("A"));
        assertEquals(Integer.valueOf(3), map.get("b"));

        assertEquals(ImmutableSet.of("a", "b"), map.keySet());

        List<Integer> values = new ArrayList<>(map.values());
        Collections.sort(values);
        assertEquals(ImmutableList.of(2, 3), values);
    }
}
