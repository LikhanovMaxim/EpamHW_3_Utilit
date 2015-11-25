package IntArrayUtils;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public final class IntArrayUtils {
    private IntArrayUtils() {
    }

    public static int[] changeSize(int[] arr, int size) {
        if (size < 0) {
            return null;
        }
        int[] changeArr = new int[size];
        if (arr == null) {
            return changeArr;
        }
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
        //size == arr.length
        return arr;
    }

    public static boolean compareExcludOrder(int[] first, int[] second) {
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
