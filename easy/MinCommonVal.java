package easy;

import java.util.Arrays;
import static utils.ArrayUtils.*;

public class MinCommonVal {

    public static int getCommon(int[] nums1, int[] nums2) {

        // remove this to reduce runtime in leetCode, but add it outside leetCode
        if(!(isNonDecreasingArray(nums1) && isNonDecreasingArray(nums2)))
            throw new IllegalArgumentException("both arrays must be non-decreasing");

        int i = 0; // nums1 pointer
        int j = 0; // nums2 pointer

        while(i < nums1.length && j < nums2.length) {

            int n1 = nums1[i];
            int n2 = nums2[j];

            if(n1 == n2) return n1;

            if(n1 < n2) i++;

            else j++;
        }

        return -1;
    }

    public static void main(String[] args) {

        System.out.println("2540. Minimum Common Value");

        int[] a1 = {1, 2, 3};
        int[] b1 = {2, 4};
        System.out.println("\nArray 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(b1));
        System.out.println("Min Common Val: " + getCommon(a1, b1));

        int[] a2 = {1, 2, 3, 6};
        int[] b2 = {2, 3, 4, 5};
        System.out.println("\nArray 1: " + Arrays.toString(a2));
        System.out.println("Array 2: " + Arrays.toString(b2));
        System.out.println("Min Common Val: " + getCommon(a2, b2));
    }
}
