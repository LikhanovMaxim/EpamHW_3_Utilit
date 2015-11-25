package IntArrayUtils;

import java.util.Arrays;

public final class Even implements PredicateIntArr {
    @Override
    public int[] getArr(int[] arr) {
        if (arr == null) {
            int[] res = {};
            return res;
        }
        int[] evenArr = new int[arr.length];
        int size = 0;
        for (int element : arr) {
            if (element % 2 == 0) {
                evenArr[size++] = element;
            }
        }
        return Arrays.copyOf(evenArr, size);
    }
}
