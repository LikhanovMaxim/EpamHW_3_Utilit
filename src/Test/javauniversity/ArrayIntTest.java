package ArrayInt;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayIntTest {

    @Test
    public void testTruncationArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        int[] mas2 = {1, 2, 3};
        int[] mas3 = {};
        assertTrue(Arrays.equals(mas, ArrayInt.truncationArray(mas, 5)));
        assertTrue(Arrays.equals(mas2, ArrayInt.truncationArray(mas, 3)));
        assertTrue(Arrays.equals(mas3, ArrayInt.truncationArray(mas, 0)));
        assertTrue(Arrays.equals(null, ArrayInt.truncationArray(null, 3)));
        assertTrue(Arrays.equals(mas, ArrayInt.truncationArray(mas, 6)));
    }

    @Test
    public void testExtensionArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        int[] mas1 = {0, 0, 0, 0, 0, 0};
        int[] mas2 = {1, 2, 3, 4, 5, 0};
        int[] mas3 = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        assertTrue(Arrays.equals(mas, ArrayInt.extensionArray(mas, 5)));
        assertTrue(Arrays.equals(mas, ArrayInt.extensionArray(mas, 4)));
        assertTrue(Arrays.equals(mas1, ArrayInt.extensionArray(null, 6)));
        assertTrue(Arrays.equals(mas2, ArrayInt.extensionArray(mas, 6)));
        assertTrue(Arrays.equals(mas3, ArrayInt.extensionArray(mas, 10)));
    }

    @Test(timeout = 1000)
    public void testCompareArrays() throws Exception {
        int[] mas={1, 2, 3 ,4, 5};
        int[] mas2={5, 4, 2, 1, 3};
        int[] mas3={1, 2, 3};
        int[] mas4={};
        assertTrue(ArrayInt.compareArrays(null, null));
        assertTrue(ArrayInt.compareArrays(mas, mas2));
        assertTrue(ArrayInt.compareArrays(mas, mas));
        assertTrue(ArrayInt.compareArrays(mas4, mas4));
        assertFalse(ArrayInt.compareArrays(null, mas3));
        assertFalse(ArrayInt.compareArrays(mas, null));
        assertFalse(ArrayInt.compareArrays(mas, mas3));
    }
}