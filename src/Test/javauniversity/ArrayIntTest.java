package ArrayInt;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ArrayIntTest {

    @Test
    public void testEqualDimenAndSizeTruncationArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(mas, ArrayInt.truncationArray(mas, 5)));
    }

    @Test
    public void testNoEqualDimenAndSizeTruncationArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        int[] result = {1, 2, 3};
        assertTrue(Arrays.equals(result, ArrayInt.truncationArray(mas, 3)));
    }

    @Test
    public void testEmptyTruncationArray() throws Exception {
        int[] mas = {1, 2, 3};
        int[] result = {};
        assertTrue(Arrays.equals(result, ArrayInt.truncationArray(mas, 0)));
    }

    @Test
    public void testNullTruncationArray() throws Exception {
        assertTrue(Arrays.equals(null, ArrayInt.truncationArray(null, 3)));
    }

    @Test
    public void testSizeMoreDimenTruncationArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(mas, ArrayInt.truncationArray(mas, 6)));
    }

    @Test
    public void testNullExtensionArray() throws Exception {
        int[] resul = {0, 0, 0, 0, 0, 0};
        assertTrue(Arrays.equals(resul, ArrayInt.extensionArray(null, 6)));
    }
    @Test
    public void testEmptyExtensionArray() throws Exception {
        int[] mas={};
        int[] resul = {0, 0, 0, 0, 0, 0};
        assertTrue(Arrays.equals(resul, ArrayInt.extensionArray(mas, 6)));
    }
    @Test
    public void testSizeEqualDimenExtensionArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(mas, ArrayInt.extensionArray(mas, 5)));
    }

    @Test
    public void testSizeMoreDimenExtensionArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        int[] result = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0};
        assertTrue(Arrays.equals(result, ArrayInt.extensionArray(mas, 10)));
    }
    @Test
    public void testSizeLessDimenExtensionArray() throws Exception {
        int[] mas = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(mas, ArrayInt.extensionArray(mas, 4)));
    }

    @Test(timeout = 1000)
    public void testNullCompareArrays() throws Exception {
        int[] mas3 = {1, 2, 3};
        assertTrue(ArrayInt.compareArrays(null, null));
        assertFalse(ArrayInt.compareArrays(null, mas3));
    }

    @Test(timeout = 1000)
    public void testEqualMasCompareArrays() throws Exception {
        int[] mas1 = {1, 2, 3, 4, 5};
        int[] mas2 = {5, 4, 2, 1, 3};
        assertTrue(ArrayInt.compareArrays(mas1, mas2));
    }

    @Test(timeout = 1000)
    public void testEqualDimenCompareArrays() throws Exception {
        int[] mas1 = {1, 2, 3, 4, 5};
        int[] mas2 = {5, 4, 2, 1, 3};
        assertTrue(ArrayInt.compareArrays(mas1, mas2));
    }

    @Test(timeout = 1000)
    public void testNoEqualDimenCompareArrays() throws Exception {
        int[] mas1 = {1, 2, 3, 4, 5};
        int[] mas2 = {5, 4, 2};
        assertFalse(ArrayInt.compareArrays(mas1, mas2));
    }

    @Test(timeout = 1000)
    public void testEqualDimenNoMasCompareArrays() throws Exception {
        int[] mas1 = {1, 2, 3, 4, 5};
        int[] mas2 = {5, 4, 2, 2, 2};
        assertFalse(ArrayInt.compareArrays(mas1, mas2));
    }
    @Test(timeout = 1000)
    public void testEmptyCompareArrays() throws Exception {
        int[] mas1 = {1, 2, 3, 4, 5};
        int[] mas2 = {};
        assertTrue(ArrayInt.compareArrays(mas1, mas1));
        assertFalse(ArrayInt.compareArrays(mas1, mas2));
    }
}