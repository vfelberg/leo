package leo;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilsTest {

    @Test
    public void testChop() throws Exception {
        assertNull(StringUtils.chop(null));
        assertEquals("", StringUtils.chop(""));
        assertEquals("abc ", StringUtils.chop("abc \r"));
        assertEquals("abc", StringUtils.chop("abc\n"));
        assertEquals("abc", StringUtils.chop("abc\r\n"));
        assertEquals("ab", StringUtils.chop("abc"));
        assertEquals("abc\nab", StringUtils.chop("abc\nabc"));
        assertEquals("", StringUtils.chop("a"));
        assertEquals("", StringUtils.chop("\r"));
        assertEquals("", StringUtils.chop("\n"));
        assertEquals("", StringUtils.chop("\r\n"));
    }


    @Test
    public void testRepeat() throws Exception {
        assertEquals(null, StringUtils.repeat(null, 2));
        assertEquals(null, StringUtils.repeat(null, 10));
        assertEquals("", StringUtils.repeat("", 0));
        assertEquals("", StringUtils.repeat("", 2));
        assertEquals("aaa", StringUtils.repeat("a", 3));
        assertEquals("abab", StringUtils.repeat("ab", 2));
        assertEquals("", StringUtils.repeat("a", -2));

    }

    @Test
    public void testRepeatWithSeparator() throws Exception {
        assertEquals(null, StringUtils.repeat(null, null, 2));
        assertEquals(null, StringUtils.repeat(null, "x", 2));
        assertEquals("", StringUtils.repeat("", null, 0));
        assertEquals("", StringUtils.repeat("", "", 2));
        assertEquals("xx", StringUtils.repeat("", "x", 3));
        assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3));


    }

    @Test
    public void testCompare(){
        assertEquals(0, StringUtils.compare(null, null));
        assertEquals(1, StringUtils.compare("", null));
    }
}