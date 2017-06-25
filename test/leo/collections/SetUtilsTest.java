package leo.collections;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import static leo.collections.SetUtils.*;
import static org.junit.Assert.*;

public class SetUtilsTest {

    @Test
    public void testDifference() throws Exception {
        assertEquals(ImmutableSet.of(), difference(ImmutableSet.of(), ImmutableSet.of()));
        assertEquals(ImmutableSet.<Integer>of(), difference(ImmutableSet.of(1, 2, 3), ImmutableSet.of(1, 2, 3)));
        assertEquals(ImmutableSet.of(1, 2, 3), difference(ImmutableSet.of(1, 2, 3), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(1, 3), difference(ImmutableSet.of(1, 2, 3), ImmutableSet.of(2, 4)));

        assertEquals(ImmutableSet.<String>of(), difference(ImmutableSet.of("1", "2", "3"), ImmutableSet.of("1", "2", "3")));
        assertEquals(ImmutableSet.of("1", "2", "3"), difference(ImmutableSet.of("1", "2", "3"), ImmutableSet.of()));
        assertEquals(ImmutableSet.of("1", "3"), difference(ImmutableSet.of("1", "2", "3"), ImmutableSet.of("2", "4")));
    }

    @Test
    public void testUnion() throws Exception {
        assertEquals(ImmutableSet.of(), union(ImmutableSet.of(), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(1, 2, 3), union(ImmutableSet.of(1, 2, 3), ImmutableSet.of(1, 2, 3)));
        assertEquals(ImmutableSet.of(1, 2, 3), union(ImmutableSet.of(1, 2, 3), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(4, 2, 1, 3), union(ImmutableSet.of(1, 2, 3), ImmutableSet.of(2, 4)));

        assertEquals(ImmutableSet.of("1", "2", "3"), union(ImmutableSet.of("1", "2", "3"), ImmutableSet.of("1", "2", "3")));
        assertEquals(ImmutableSet.of("1", "2", "3"), union(ImmutableSet.of("1", "2", "3"), ImmutableSet.of()));
        assertEquals(ImmutableSet.of("2", "1", "4", "3"), union(ImmutableSet.of("1", "2", "3"), ImmutableSet.of("2", "4")));
    }


    @Test
    public void testIntersection() throws Exception {
        assertEquals(ImmutableSet.of(), intersection(ImmutableSet.of(), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(1, 2, 3), intersection(ImmutableSet.of(1, 2, 3), ImmutableSet.of(1, 2, 3)));
        assertEquals(ImmutableSet.<Integer>of(), intersection(ImmutableSet.of(1, 2, 3), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(2, 3), intersection(ImmutableSet.of(1, 2, 3), ImmutableSet.of(2, 4, 5, 2, 3)));
    }

    @Test
    public void testSymmetricDifference() throws Exception {
        assertEquals(ImmutableSet.of(), symmetricDifference(ImmutableSet.of(), ImmutableSet.of()));
        assertEquals(ImmutableSet.<Integer>of(), symmetricDifference(ImmutableSet.of(1, 2, 3), ImmutableSet.of(1, 2, 3)));
        assertEquals(ImmutableSet.of(1, 2, 3), symmetricDifference(ImmutableSet.of(1, 2, 3), ImmutableSet.of()));
        assertEquals(ImmutableSet.of(1, 4, 5), symmetricDifference(ImmutableSet.of(1, 2, 3), ImmutableSet.of(2, 4, 5, 2, 3)));
    }
}