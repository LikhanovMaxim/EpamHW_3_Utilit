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
        int[] emptyArr = {};
        assertTrue(Arrays.equals(emptyArr, IntArrayUtils.changeSize(arr, -3)));
    }

    @Test(timeout = 1000)
    public void nullCompareExcludOrder() throws Exception {
        int[] arr3 = {1, 2, 3};
        assertTrue(IntArrayUtils.compareExcludeOrder(null, null));
        assertFalse(IntArrayUtils.compareExcludeOrder(null, arr3));
    }

    @Test(timeout = 1000)
    public void equallyArrCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 1, 3};
        assertTrue(IntArrayUtils.compareExcludeOrder(arr1, arr2));
        assertTrue(IntArrayUtils.compareExcludeOrder(arr2, arr1));
    }

    @Test(timeout = 1000)
    public void noEqualDimenCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2};
        assertFalse(IntArrayUtils.compareExcludeOrder(arr1, arr2));
        assertFalse(IntArrayUtils.compareExcludeOrder(arr2, arr1));
    }

    @Test(timeout = 1000)
    public void equalDimenNoEquallyArrCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 2, 2};
        assertFalse(IntArrayUtils.compareExcludeOrder(arr1, arr2));
        assertFalse(IntArrayUtils.compareExcludeOrder(arr2, arr1));
    }

    @Test(timeout = 1000)
    public void emptyCompareExcludOrder() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {};
        assertTrue(IntArrayUtils.compareExcludeOrder(arr1, arr1));
        assertFalse(IntArrayUtils.compareExcludeOrder(arr1, arr2));
    }

    @Test
    public void testShuffle() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] shuffleArr = IntArrayUtils.shuffle(arr);
        assertTrue(IntArrayUtils.compareExcludeOrder(arr, shuffleArr));
    }

    @Test
    public void nullShuffle() throws Exception {
        int[] result = {};
        assertTrue(Arrays.equals(result, IntArrayUtils.shuffle(null)));
    }

    @Test
    public void evenFilter() throws Exception {
        PredicateInt predicateInt = new Even();
        int[] arr = {-4, -3, -2, -1, 0, 5, 6, 7, 8};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {-4, -2, 0, 6, 8};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void evenEmptyFilter() throws Exception {
        PredicateInt predicateInt = new Even();
        int[] arr = {};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void evenNullFilter() throws Exception {
        PredicateInt predicateInt = new Even();
        int[] arr = null;
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void moreHundredFilter() throws Exception {
        PredicateInt predicateInt = new MoreHundred();
        int[] arr = {-400, -300, -200, -100, 0, 500, 600, 700, 800};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {500, 600, 700, 800};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void moreHundredEmptyFilter() throws Exception {
        PredicateInt predicateInt = new MoreHundred();
        int[] arr = {};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void moreHundredNullFilter() throws Exception {
        PredicateInt predicateInt = new MoreHundred();
        int[] arr = null;
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void primeFilter() throws Exception {
        PredicateInt predicateInt = new Prime();
        int[] arr = {-7, -6, -5, -4, -1, 0, 1, 2, 8, 117};
        arr = IntArrayUtils.filter(arr, predicateInt);
        System.out.println(IntArrayUtils.toString(arr));
        int[] result = {-7, -5, -1, 1, 2};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void primeEmptyFilter() throws Exception {
        PredicateInt predicateInt = new Prime();
        int[] arr = {};
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void primeNullFilter() throws Exception {
        PredicateInt predicateInt = new Prime();
        int[] arr = null;
        arr = IntArrayUtils.filter(arr, predicateInt);
        int[] result = {};
        assertTrue(Arrays.equals(result, arr));
    }

    @Test
    public void testToString() throws Exception {
        int[] arr = {1, 2, 3, 4, 5};
        String result = "{1 2 3 4 5 }";
        assertTrue(result.equals(IntArrayUtils.toString(arr)));
    }

    @Test
    public void nullToString() throws Exception {
        int[] arr = null;
        String result = "null";
        assertTrue(result.equals(IntArrayUtils.toString(arr)));
    }

    @Test
    public void emptyToString() throws Exception {
        int[] arr = {};
        String result = "{}";
        assertTrue(result.equals(IntArrayUtils.toString(arr)));
    }
}