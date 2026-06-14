package medium;

import java.util.*;

public class PrefixArray {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        if(A.length != B.length) throw new IllegalArgumentException("both array length must be equal");

        int n = A.length;
        int common = 0;
        int[] prefixes = new int[n];
        Set<Integer> prevNumsA = new HashSet<>(n);
        Set<Integer> prevNumsB = new HashSet<>(n);
        IllegalArgumentException invalid = new IllegalArgumentException("invalid permutation");

        for(int i = 0; i < n; i++) {

            int a = A[i];
            int b = B[i];

            if(a == 0 || b == 0 || a > n || b > n) throw invalid;

            if(prevNumsA.contains(a)) throw invalid;
            if(prevNumsB.contains(a)) common++;
            else prevNumsA.add(a);

            if(prevNumsB.contains(b)) throw invalid;
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
