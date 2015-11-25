package IntArrayUtils;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntArrayUtilsTest {


    @Test
    public void equalDimenAndSizeChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(arr, IntArrayUtils.changeSize(arr, 5)));
    }

    @Test
    public void sizeZeroChangeSize() throws Exception {
        int[] arr = {1, 2, 3};
        int[] result = {};
        assertTrue(Arrays.equals(result, IntArrayUtils.changeSize(arr, 0)));
    }

    @Test
    public void emptyChangeSize() throws Exception {
        int[] arr = {};
        int[] resul = {0, 0, 0};
        assertTrue(Arrays.equals(resul, IntArrayUtils.changeSize(arr, 3)));
    }

    @Test
    public void nullChangeSize() throws Exception {
        int[] arr = {0, 0, 0};
        assertTrue(Arrays.equals(arr, IntArrayUtils.changeSize(null, 3)));
    }

    @Test
    public void sizeMoreDimenChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = {1, 2, 3, 4, 5, 0, 0};
        assertTrue(Arrays.equals(result, IntArrayUtils.changeSize(arr, 7)));
    }

    @Test
    public void sizeLessDimenChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = {1, 2, 3};
        assertTrue(Arrays.equals(result, IntArrayUtils.changeSize(arr, 3)));
    }

    @Test
    public void sizeLessZeroChangeSize() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        assertTrue(Arrays.equals(null, IntArrayUtils.changeSize(arr, -3)));
    }

    @Test(timeout = 1000)
    public void nullCompareExcludOrder() throws Exception {
        int[] arr3 = {1, 2, 3};
        assertTrue(IntArrayUtils.compareExcludOrder(null, null));
        assertFalse(IntArrayUtils.compareExcludOrder(null, arr3));
    }

    @Test(timeout = 1000)
    public void equallyArrCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 1, 3};
        assertTrue(IntArrayUtils.compareExcludOrder(arr1, arr2));
        assertTrue(IntArrayUtils.compareExcludOrder(arr2, arr1));
    }

    @Test(timeout = 1000)
    public void noEqualDimenCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2};
        assertFalse(IntArrayUtils.compareExcludOrder(arr1, arr2));
        assertFalse(IntArrayUtils.compareExcludOrder(arr2, arr1));
    }

    @Test(timeout = 1000)
    public void equalDimenNoEquallyArrCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 2, 2};
        assertFalse(IntArrayUtils.compareExcludOrder(arr1, arr2));
        assertFalse(IntArrayUtils.compareExcludOrder(arr2, arr1));
    }

    @Test(timeout = 1000)
    public void emptyCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {};
        assertTrue(IntArrayUtils.compareExcludOrder(arr1, arr1));
        assertFalse(IntArrayUtils.compareExcludOrder(arr1, arr2));
    }

    @Test
    public void testShuffle() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] shuffleArr = IntArrayUtils.shuffle(arr);
        assertTrue(IntArrayUtils.compareExcludOrder(arr, shuffleArr));
    }

    @Test
    public void nullShuffle() throws Exception {
        assertTrue(Arrays.equals(null, IntArrayUtils.shuffle(null)));
    }

    @Test
    public void evenFilter() throws Exception {
        PredicateIntArr predicateInt = new PredicateIntArr.Even();
        int[] arr = {-4, -3, -2, -1, 0, 5, 6, 7, 8};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {-4, -2, 0, 6, 8};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void evenEmptyFilter() throws Exception {
        PredicateIntArr predicateInt = new PredicateIntArr.Even();
        int[] arr = {};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void evenNullFilter() throws Exception {
        PredicateIntArr predicateInt = new PredicateIntArr.Even();
        int[] arr = null;
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }
}