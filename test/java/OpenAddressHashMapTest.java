import com.simpletask.implementations.hashMap.OpenAddressHashMap;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OpenAddressHashMapTest {
    private OpenAddressHashMap map;
    private static final Integer KEY_1 = 1129;
    private static final Integer KEY_2 = 156;
    private static final Long VALUE_1 = 555L;
    private static final Long VALUE_2 = 666L;
    private static final int NUM_OF_ELEMENTS = 150;

    @Before
    public void setUp() {
        map = new OpenAddressHashMap();
    }

    @Test
    public void testPutWithRightEntry() {
        assertTrue(VALUE_1.equals(map.put(KEY_1, VALUE_1)));
        assertEquals(VALUE_2, map.put(KEY_2, VALUE_2));
    }

    @Test
    public void testPutGet() {
        map.put(KEY_1, VALUE_1);
        map.put(KEY_2, VALUE_2);
        Long result1 = map.get(KEY_1);
        Long result2 = map.get(KEY_2);
        assertEquals(result1, map.get(KEY_1));
        assertEquals(result2, map.get(KEY_2));
    }

    @Test
    public void testDelete() {
        Long result = -1L;
        map.put(KEY_1, VALUE_1);
        map.put(KEY_2, VALUE_2);
        assertTrue(map.delete(KEY_1));
        assertTrue(map.delete(KEY_2));
        assertEquals(result, map.get(KEY_1));
        assertEquals(result, map.get(KEY_2));
    }

    @Test
    public void testSizeWhenAddAndRemoveNote() {
        map.put(KEY_1, VALUE_1);
        map.put(KEY_2, VALUE_2);
        assertEquals(2, map.size());
        map.delete(KEY_1);
        map.delete(KEY_2);
        assertEquals(0, map.size());
    }

    @Test
    public void testMapCollisions() {
        for (int i = 0; i < NUM_OF_ELEMENTS; i++) {
            long j = VALUE_1 + i;
            map.put(i, j);
        }
        for (int i = 0; i < NUM_OF_ELEMENTS; i++) {
            Long checkValue = VALUE_1 + i;
            Long value = map.get(i);
            assertEquals(value, checkValue);
        }

    }
}