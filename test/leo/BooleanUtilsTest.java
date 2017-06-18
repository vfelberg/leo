package leo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BooleanUtilsTest {
    @Test
    public void testBoolean(){
        assertEquals("yes", BooleanUtils.toStringYesNo(true));
        assertEquals("no", BooleanUtils.toStringYesNo(false));
    }

    @Test
    public void testToString(){
        assertEquals("true", BooleanUtils.toString(true, "true", "false"));
        assertEquals("false", BooleanUtils.toString(false, "true", "false"));
        assertEquals("yes", BooleanUtils.toString(true, "yes", "no"));
        assertEquals("no", BooleanUtils.toString(false, "yes", "no"));
    }

    @Test
    public void testAnd(){
        assertEquals(true, BooleanUtils.and(true,true));
        assertEquals(false, BooleanUtils.and(false,false));
        assertEquals(false, BooleanUtils.and(true,false));
        assertEquals(false, BooleanUtils.and(true,true,false));
        assertEquals(true, BooleanUtils.and(true,true,true));
    }

    @Test
    public void testOr(){
        assertEquals(true, BooleanUtils.or(true, true));
        assertEquals(false, BooleanUtils.or(false, false));
        assertEquals(true, BooleanUtils.or(true, false));
    }
}
