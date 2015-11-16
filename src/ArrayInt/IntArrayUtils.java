package ArrayInt;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public final class IntArrayUtils {
    private IntArrayUtils() {
    }

    public static void print(int[] arr) {
        if (arr == null) {
            System.out.println("The array is empty.");
            return;
        }
        int i;
        System.out.print("[");
        for (i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        if (arr.length != 0) {
            System.out.print(arr[i]);
        }
        System.out.println("]");
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

    public static int[] cpyArray(int[] cpyarr) {
        if (cpyarr == null) {
            return null;
        }
        int[] newarr = new int[cpyarr.length];
        for (int i = 0; i < cpyarr.length; i++) {
            newarr[i] = cpyarr[i];
        }
        return newarr;
    }

    public static boolean compareArrays(int[] firstarr, int[] secondarr) {
        if (firstarr == null && secondarr == null) {
            return true;
        }
        if (firstarr == null || secondarr == null || firstarr.length != secondarr.length) {
            return false;
        }
        int[] firstArr = cpyArray(firstarr);
        int[] secondArr = cpyArray(secondarr);
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        boolean flag = true;
        for (int i = 0; i < firstArr.length; i++) {
            if (firstArr[i] != secondArr[i]) {
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
        int[] randarr = cpyArray(arr);
        int index, cur;
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            index = abs(random.nextInt()) % randarr.length;
            cur = randarr[index];
            randarr[index] = randarr[i];
            randarr[i] = cur;
        }
        return randarr;
    }
}
