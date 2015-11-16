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
    public void NullCompareArrays() throws Exception {
        int[] arr3 = {1, 2, 3};
        assertTrue(IntArrayUtils.compareExcludOrder(null, null));
        assertFalse(IntArrayUtils.compareExcludOrder(null, arr3));
    }

    @Test(timeout = 1000)
    public void EqualarrCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 1, 3};
        assertTrue(IntArrayUtils.compareExcludOrder(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void EqualDimenCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 1, 3};
        assertTrue(IntArrayUtils.compareExcludOrder(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void tNoEqualDimenCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2};
        assertFalse(IntArrayUtils.compareExcludOrder(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void EqualDimenNoarrCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {5, 4, 2, 2, 2};
        assertFalse(IntArrayUtils.compareExcludOrder(arr1, arr2));
    }

    @Test(timeout = 1000)
    public void EmptyCompareArrays() throws Exception {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {};
        assertTrue(IntArrayUtils.compareExcludOrder(arr1, arr1));
        assertFalse(IntArrayUtils.compareExcludOrder(arr1, arr2));
    }

    @Test
    public void shuffleArr() throws Exception {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] shufflArr = IntArrayUtils.shuffleArr(arr);
        assertTrue(IntArrayUtils.compareExcludOrder(arr, shufflArr));
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != shufflArr[i]) {
                count++;
            }
        }
        assertTrue(count > 0);
    }

    @Test
    public void NullshuffleArr() throws Exception {
        assertTrue(Arrays.equals(null, IntArrayUtils.shuffleArr(null)));
    }
}