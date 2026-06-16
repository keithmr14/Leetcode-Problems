package utils;

import java.util.Arrays;

public class ArrayUtils {

    public static void print2dPrimOneLine(int[][] arrays) {

        int n = arrays.length;

        for(int i = 0; i < n; i++) {

            System.out.print(Arrays.toString(arrays[i]));
            if(i != n - 1) System.out.print(", ");
        }
    }

    public static void print2dPrimMultiLine(int[][] arrays) {

        for (int[] array : arrays)

            System.out.println(Arrays.toString(array));
    }

    public static void print2dPrimMultiLine(char[][] arrays) {

        for (char[] array : arrays)

            System.out.println(Arrays.toString(array));
    }

    public static boolean isNonIncreasingArray(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]) return false;
        }

        return true;
    }
}
