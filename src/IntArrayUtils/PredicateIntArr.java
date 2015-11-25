package IntArrayUtils;

import java.util.Arrays;

public interface PredicateIntArr {
    int[] getArr(int[] arr);

    final class Even implements PredicateIntArr {
        @Override
        public int[] getArr(int[] arr) {
            if (arr == null) {
                int[] result = {};
                return result;
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

    final class MoreHundred implements PredicateIntArr {
        @Override
        public int[] getArr(int[] arr) {
            if (arr == null) {
                int[] result = {};
                return result;
            }
            int[] result = new int[arr.length];
            int size = 0;
            for (int element : arr) {
                if (element > 100) {
                    result[size++] = element;
                }
            }
            return Arrays.copyOf(result, size);
        }
    }

    final class Prime implements PredicateIntArr {
        private boolean checkPrime(int number) {
            number = Math.abs(number);
            for (int i = 2; i * i <= number; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int[] getArr(int[] arr) {
            if (arr == null) {
                int[] res = {};
                return res;
            }
            int[] evenArr = new int[arr.length];
            int size = 0;
            for (int element : arr) {
                if (checkPrime(element)) {
                    evenArr[size++] = element;
                }
            }
            return Arrays.copyOf(evenArr, size);
        }
    }

}