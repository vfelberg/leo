package leo;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class SetTest {
    @Test
    public void testSetProperties() {
        Set<String> set = new HashSet<>();
        assertEquals(0, set.size());

        set.add("a");
        assertEquals(1, set.size());

        set.add("a");
        assertEquals(1, set.size());

        set.add("b");
        assertEquals(2, set.size());

        set.add("a");
        assertEquals(2, set.size());

        assertEquals(ImmutableSet.of("b", "a"), set);
    }
}
