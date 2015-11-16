package ArrayInt;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntArrayUtilsTest {


    @Test
    public void EqualDimenAndSizeChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(arr, IntArrayUtils.changeSize(arr, 5)));
    }

    @Test
    public void NoEqualDimenAndSizeChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = {1, 2, 3};
        assertTrue(Arrays.equals(result, IntArrayUtils.changeSize(arr, 3)));
    }

    @Test
    public void SizeZeroChangeSize() throws Exception {
        int[] arr = {1, 2, 3};
        int[] result = {};
        assertTrue(Arrays.equals(result, IntArrayUtils.changeSize(arr, 0)));
    }

    @Test
    public void EmptyChangeSize() throws Exception {
        int[] arr = {};
        int[] resul = {0, 0, 0};
        assertTrue(Arrays.equals(resul, IntArrayUtils.changeSize(arr, 3)));
    }

    @Test
    public void NullChangeSize() throws Exception {
        int[] arr = {0, 0, 0};
        assertTrue(Arrays.equals(arr, IntArrayUtils.changeSize(null, 3)));
    }

    @Test
    public void SizeMoreDimenChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = {1, 2, 3, 4, 5, 0, 0};
        assertTrue(Arrays.equals(result, IntArrayUtils.changeSize(arr, 7)));
    }

    @Test
    public void SizeLessZeroChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(null, IntArrayUtils.changeSize(arr, -3)));
    }

    @Test(timeout = 1000)
    public void testNullCompareArrays() throws Exception {
        int[] arr3 = {1, 2, 3};
        assertTrue(IntArrayUtils.compareArrays(null, null));
        assertFalse(IntArrayUtils.compareArrays(null, arr3));
    }

    @Test(timeout = 1000)
    public void testEqualarrCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 1, 3};
        assertTrue(IntArrayUtils.compareArrays(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void testEqualDimenCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 1, 3};
        assertTrue(IntArrayUtils.compareArrays(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void testNoEqualDimenCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2};
        assertFalse(IntArrayUtils.compareArrays(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void testEqualDimenNoarrCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 2, 2};
        assertFalse(IntArrayUtils.compareArrays(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void testEmptyCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {};
        assertTrue(IntArrayUtils.compareArrays(arr1, arr1));
        assertFalse(IntArrayUtils.compareArrays(arr1, arr2));
    }
}