package utils;

import java.util.Arrays;

public class ArrayUtils {

    public static void print2dIntOneLine(int[][] arrays) {
        
        int n = arrays.length;
        
        for(int i = 0; i < n; i++) {
            System.out.print(Arrays.toString(arrays[i]));
            if(i != n - 1) System.out.print(", ");
        }
    }

    public static void print2dIntMultiLine(int[][] arrays) {
        
        int n = arrays.length;
        
        for(int i = 0; i < n; i++) {
            System.out.print(Arrays.toString(arrays[i]));
            if(i != n - 1) System.out.print("\n");
        }
    }
}
