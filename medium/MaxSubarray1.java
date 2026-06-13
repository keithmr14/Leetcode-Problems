package medium;

import java.util.Arrays;

public class MaxSubarray1 {

    public static long maxTotalValue(int[] nums, int k) {

        if(k < 0) throw new IllegalArgumentException("k must be >= 0");

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int num : nums) {
            if(num > max) max = num;
            if(num < min) min = num;
        }
        long diff = max - min;
        return diff * k;
    }

    public static void main(String[] args) {

        System.out.println("3689. Maximum Total Subarray Value I");

        // example 1
        int[] a1 = {1, 3, 2};
        int k1 = 2;
        System.out.println("\nk = " + k1 + "    " + Arrays.toString(a1));
        System.out.println("Max Subarray Val: " + maxTotalValue(a1, k1));

        // example 2
        int[] a2 = {4, 2, 5, 1};
        int k2 = 3;
        System.out.println("\nk = " + k2 + "    " + Arrays.toString(a2));
        System.out.println("Max Subarray Val: " + maxTotalValue(a2, k2));
    }
}
