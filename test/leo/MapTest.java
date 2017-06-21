package leo;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class MapTest {
    @Test
    public void testMapProperties() {
        Map<String, Integer> map = new HashMap<>();
        assertEquals(0, map.size());

        map.put("a", 1);
        assertEquals(1, map.size());
        assertEquals(Integer.valueOf(1), map.get("a"));

        map.put("a", 2);
        assertEquals(1, map.size());
        assertEquals(Integer.valueOf(2), map.get("a"));

        map.put("b", 3);
        assertEquals(2, map.size());
        assertEquals(Integer.valueOf(2), map.get("a"));
        assertEquals(Integer.valueOf(3), map.get("b"));

        assertEquals(ImmutableSet.of("a", "b"), map.keySet());
        assertEquals(ImmutableList.of(2, 3), new ArrayList<>(map.values()));
    }
}
