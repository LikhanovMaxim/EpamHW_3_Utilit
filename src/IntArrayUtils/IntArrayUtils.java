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
            throw new ArrayIndexOutOfBoundsException("the size is less than zero");
        }
        if (arr == null) {
            throw new NullPointerException("at the entrance gave an empty array");
        }
        int[] changeArr = new int[size];
        if (size > arr.length) {
            for (int i = 0; i < arr.length; i++) {
                changeArr[i] = arr[i];
            }
            return changeArr;
        }
        if (size < arr.length) {
            changeArr = Arrays.copyOf(arr, size);
            return changeArr;
        }
        return arr;
    }

    public static boolean compareExcludeOrder(int[] first, int[] second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null || first.length != second.length) {
            return false;
        }
        int[] firstCopy = Arrays.copyOf(first, first.length);
        int[] secondCopy = Arrays.copyOf(second, second.length);
        Arrays.sort(firstCopy);
        Arrays.sort(secondCopy);
        boolean flag = true;
        for (int i = 0; i < firstCopy.length; i++) {
            if (firstCopy[i] != secondCopy[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int[] shuffle(int[] arr) {
        if (arr == null) {
            return null;
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

    public static int[] filter(int[] arr, PredicateIntArr predicate) {
        return predicate.getArr(arr);
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
