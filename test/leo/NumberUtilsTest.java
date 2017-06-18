package leo;

import org.junit.Test;

import static org.junit.Assert.*;

public class NumberUtilsTest {

    @Test
    public void testMaxDouble() throws Exception {
        assertEquals(22d, NumberUtils.max(12, 9, 18, -10, 22, 21, 0, 7, -3), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxDoubleEmptyArray() throws Exception {
        NumberUtils.max();
    }

    @Test
    public void testMaxInt() throws Exception {
        assertEquals(18, NumberUtils.max(12, 9, 18));
    }


}