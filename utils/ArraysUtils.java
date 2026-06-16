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

    public static boolean checkNonIncreasing2Array(int[] a1, int[] a2) {

        boolean first = true;
        int lastNum = -1;

        for(int num : a1) {
            if(!first) {
                if(num > lastNum) return false;
            }
            else first = false;

            lastNum = num;
        }

        first = true;
        lastNum = -1;

        for(int num : a2) {
            if(!first) {
                if(num > lastNum) return false;
            }
            else first = false;

            lastNum = num;
        }

        return true;
    }
}
