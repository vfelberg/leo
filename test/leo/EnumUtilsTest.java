package leo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class EnumUtilsTest {

    @Test
    public void testGetEnumMap() throws Exception {
        Map<String, TestEnum1> enumMap1 = new HashMap<>();
        enumMap1.put("A", TestEnum1.A);
        enumMap1.put("B", TestEnum1.B);
        enumMap1.put("C", TestEnum1.C);
        assertEquals(enumMap1, EnumUtils.getEnumMap(TestEnum1.class));

        Map<String, TestEnum2> enumMap2 = new HashMap<>();
        enumMap2.put("D", TestEnum2.D);
        enumMap2.put("E", TestEnum2.E);
        enumMap2.put("F", TestEnum2.F);
        assertEquals(enumMap2, EnumUtils.getEnumMap(TestEnum2.class));
    }

}