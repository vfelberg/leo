package leo.collections;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import static leo.collections.SetUtils.difference;
import static org.junit.Assert.*;

public class SetUtilsTest {

    @Test
    public void testDifference() throws Exception {
        assertEquals(ImmutableSet.of(), difference(ImmutableSet.of(), ImmutableSet.of()));
        assertEquals(ImmutableSet.<Integer>of(), difference(ImmutableSet.of(1, 2, 3), ImmutableSet.of(1, 2, 3)));
        assertEquals(ImmutableSet.of(1, 2, 3), difference(ImmutableSet.of(1, 2, 3), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(1, 3), difference(ImmutableSet.of(1, 2, 3), ImmutableSet.of(2)));

        assertEquals(ImmutableSet.<String>of(), difference(ImmutableSet.of("1", "2", "3"), ImmutableSet.of("1", "2", "3")));
        assertEquals(ImmutableSet.of("1", "2", "3"), difference(ImmutableSet.of("1", "2", "3"), ImmutableSet.of()));
        assertEquals(ImmutableSet.of("1", "3"), difference(ImmutableSet.of("1", "2", "3"), ImmutableSet.of("2")));
    }
}