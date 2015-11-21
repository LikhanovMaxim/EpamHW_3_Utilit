package ArrayInt;

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
        int[] changeArr = {};
        if (arr == null) {
            changeArr = new int[size];
            return changeArr;
        }
        if (size > arr.length) {
            changeArr = new int[size];
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

    public static boolean compareExcludOrder(int[] firstArr, int[] secondArr) {
        if (firstArr == null && secondArr == null) {
            return true;
        }
        if (firstArr == null || secondArr == null || firstArr.length != secondArr.length) {
            return false;
        }
        int[] firArr = Arrays.copyOf(firstArr, firstArr.length);
        int[] secArr = Arrays.copyOf(secondArr, secondArr.length);
        Arrays.sort(firArr);
        Arrays.sort(secArr);
        boolean flag = true;
        for (int i = 0; i < firArr.length; i++) {
            if (firArr[i] != secArr[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static int[] shuffleArr(int[] arr) {
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
}
