package ArrayInt;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public final class ArrayInt {
    private ArrayInt() {
    }

    public static void printArray(int[] mas) {
        if (mas == null) {
            System.out.println("The array is empty.");
            return;
        }
        int i;
        System.out.print("[");
        for (i = 0; i < mas.length - 1; i++) {
            System.out.print(mas[i] + ", ");
        }
        if (mas.length != 0) {
            System.out.print(mas[i]);
        }
        System.out.println("]");
    }

    public static int[] truncationArray(int[] mas, int size) {
        if (mas == null) {
            return mas;
        }
        if (size > mas.length) {
            //System.out.println("The 'size' should be less than the dimension of the array.");
            return mas;
        }
        if (size == mas.length) {
            return mas;
        }
        int[] truncArr;
        truncArr = new int[size];
        for (int i = 0; i < size; i++) {
            truncArr[i] = mas[i];
        }
        return truncArr;
    }

    public static int[] extensionArray(int[] mas, int size) {
        if (mas == null) {
            int[] extenArr = new int[size];
            for (int i = 0; i < size; i++) {
                extenArr[i] = 0;
            }
            return extenArr;
        }
        if (size < mas.length) {
            System.out.println("wrong extension(size<mas.lenght)");
            return mas;
        }
        int[] extenArr;
        extenArr = new int[size];
        int i;
        for (i = 0; i < mas.length; i++) {
            extenArr[i] = mas[i];
        }
        for (; i < size; i++) {
            extenArr[i] = 0;
        }
        return extenArr;
    }

    public static int[] cpyArray(int[] cpyMas) {
        if (cpyMas == null) {
            return null;
        }
        int[] newMas = new int[cpyMas.length];
        for (int i = 0; i < cpyMas.length; i++) {
            newMas[i] = cpyMas[i];
        }
        return newMas;
    }

    public static boolean compareArrays(int[] firstMas, int[] secondMas) {
        if (firstMas == null && secondMas == null) {
            return true;
        }
        if (firstMas == null || secondMas == null || firstMas.length != secondMas.length) {
            return false;
        }
        int[] firstArr = cpyArray(firstMas);
        int[] secondArr = cpyArray(secondMas);
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

    public static int[] shuffleArr(int[] mas) {
        if(mas==null){
            return null;
        }
        int[] randMas=cpyArray(mas);
        int index, cur;
        Random random=new Random();
        for(int i=0; i<mas.length; i++){
            index=abs(random.nextInt())%randMas.length;
            cur=randMas[index];
            randMas[index]=randMas[i];
            randMas[i]=cur;
        }
        return randMas;
    }
}
