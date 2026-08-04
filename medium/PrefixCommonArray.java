package medium;

import java.util.*;

public class PrefixCommonArray {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        if(A.length != B.length) throw new IllegalArgumentException("both arrays must be equal length");

        int n = A.length;
        int common = 0;
        int[] prefixes = new int[n];
        Set<Integer> prevNumsA = new HashSet<>(n);
        Set<Integer> prevNumsB = new HashSet<>(n);

        for(int i = 0; i < n; i++) {

            int a = A[i];
            int b = B[i];

            if(a < 1 || a > n)
                throw new IllegalArgumentException("invalid integer " + a + " in array 1, accepts only 1 to n (arrays' length)");
            if(b < 1 || b > n)
                throw new IllegalArgumentException("invalid integer " + b + " in array 2, accepts only 1 to n (arrays' length)");

            if(prevNumsA.contains(a))
                throw new IllegalArgumentException("integer " + a + " appears twice in array 1, invalid as permutation");

            if(prevNumsB.contains(a)) common++;
            else prevNumsA.add(a);

            if(prevNumsB.contains(b))
                throw new IllegalArgumentException("integer " + b + " appears twice in array 2, invalid as permutation");

            if(prevNumsA.contains(b)) common++;
            else prevNumsB.add(b);

            prefixes[i] = common;
        }

        return prefixes;
    }

    public static void main(String[] args) {

        System.out.println("2657. Find the Prefix Common Array of Two Arrays");

        // example 1
        int[] a1 = {1, 3, 2, 4};
        int[] b1 = {3, 1, 2, 4};
        System.out.println("\nArray 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(b1));
        System.out.println("Prefix Array: " + Arrays.toString(findThePrefixCommonArray(a1, b1)));

        // example 2
        int[] a2 = {2, 3, 1};
        int[] b2 = {3, 1, 2};
        System.out.println("\nArray 1: " + Arrays.toString(a2));
        System.out.println("Array 2: " + Arrays.toString(b2));
        System.out.println("Prefix Array: " + Arrays.toString(findThePrefixCommonArray(a2, b2)));
    }
}
