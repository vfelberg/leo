package leo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class ListTest {
    @Test
    public void testListProperties() {
        List<String> list = new ArrayList<>();
        assertEquals(0, list.size());

        list.add("a");
        assertEquals(1, list.size());

        list.add("a");
        assertEquals(2, list.size());

        list.add("b");
        assertEquals(3, list.size());

        list.add("a");
        assertEquals(4, list.size());

        assertEquals(ImmutableList.of("a", "a", "b", "a"), list);

        Collections.sort(list);
        assertEquals(ImmutableList.of("a", "a", "a", "b"), list);
    }
}
