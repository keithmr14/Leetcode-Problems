package medium;

import java.util.Arrays;
import static utils.ArrayUtils.checkNonIncreasing2Array;

public class MaxDistance {

    public static int maxDistance(int[] nums1, int[] nums2) {

        int maxDist = 0;
        int i = 0;
        int j = 1;

        // remove this to reduce runtime in leetCode and add it outside leetCode
        if(checkNonIncreasing2Array(nums1, nums2))
            throw new IllegalArgumentException("both arrays must be non-increasing");

        while(maxDist < nums2.length - 1 - i && i < nums1.length && j < nums2.length) {

            int num1 = nums1[i];
            int num2 = nums2[j];

            if(num1 <= num2) maxDist = Math.max(j - i, maxDist);
            else i++;
            j++;
        }

        return maxDist;
    }

    public static void main(String[] args) {

        System.out.println("1855. Maximum Distance Between a Pair of Values");

        // example 1
        int[] a1 = {55, 30, 5, 4, 2};
        int[] a2 = {100, 20, 10, 10, 5};
        System.out.println("\nArray 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(a2));
        System.out.println("Max Distance: " + maxDistance(a1, a2));

        // example 2
        int[] b1 = {2, 2, 2};
        int[] b2 = {10, 10, 1};
        System.out.println("\nArray 1: " + Arrays.toString(b1));
        System.out.println("Array 2: " + Arrays.toString(b2));
        System.out.println("Max Distance: " + maxDistance(b1, b2));
    }
}
