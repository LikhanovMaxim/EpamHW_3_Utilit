package IntArrayUtils;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public final class IntArrayUtils {
    private IntArrayUtils() {
    }

    public static int[] changeSize(int[] arr, int size) {
        try {
            return tryChangeSize(arr, size);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            int[] emptyArr = {};
            return emptyArr;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return new int[size];
        }
    }

    private static int[] tryChangeSize(int[] arr, int size) throws RuntimeException {
        if (size < 0) {
            throw new ArrayIndexOutOfBoundsException("The size is less than zero");
        }
        if (arr == null) {
            throw new NullPointerException("At the entrance gave an null array");
        }
        int[] changeArr = new int[size];
        if (size > arr.length) {
            System.arraycopy(arr, 0, changeArr, 0, arr.length);
            return changeArr;
        }
        if (size < arr.length) {
            changeArr = Arrays.copyOf(arr, size);
            return changeArr;
        }
        return arr;
    }

    public static boolean compareExcludeOrder(int[] first, int[] second) {
        try {
            return tryCompareExcludeOrder(first, second);
        } catch (NullPointerException e) {
            if (first == null && second == null) {
                return true;
            }
            e.printStackTrace();
            return false;
        } catch (ArraysSizeDifferentException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean tryCompareExcludeOrder(int[] first, int[] second) throws RuntimeException {
        if (first == null || second == null) {
            throw new NullPointerException("At the entrance gave an null array");
        }
        if (first.length != second.length) {
            throw new ArraysSizeDifferentException("Different sizes of arrays");
        }
        int[] firstCopy = Arrays.copyOf(first, first.length);
        int[] secondCopy = Arrays.copyOf(second, second.length);
        Arrays.sort(firstCopy);
        Arrays.sort(secondCopy);
        for (int i = 0; i < firstCopy.length; i++) {
            if (firstCopy[i] != secondCopy[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] shuffle(int[] arr) {
        try {
            return tryShuffle(arr);
        } catch (NullPointerException e) {
            e.printStackTrace();
            int[] emptyArr = {};
            return emptyArr;
        }
    }

    private static int[] tryShuffle(int[] arr) throws RuntimeException {
        if (arr == null) {
            throw new NullPointerException("At the entrance gave an null array");
        }
        int[] randArr = Arrays.copyOf(arr, arr.length);
        int index, cur;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            index = abs(random.nextInt()) % randArr.length;
            cur = randArr[index];
            randArr[index] = randArr[i];
            randArr[i] = cur;
        }
        return randArr;
    }

    public static int[] filter(int[] arr, PredicateInt predicate) {
        if (arr == null) {
            int[] tryArr = {};
            return tryArr;
        }
        int[] filter = new int[arr.length];
        int size = 0;
        for (int element : arr) {
            if (predicate.apply(element)) {
                filter[size] = element;
                size++;
            }
        }
        filter = Arrays.copyOf(filter, size);
        return filter;
    }

    public static String toString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        String result = "{";
        for (int element : arr) {
            result += element + " ";
        }
        result += "}";
        return result;
    }
}
