package easy;

import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(m < 0 || n < 0) throw new IllegalArgumentException("m and n mustn't be less than 0");
        if(n != nums2.length) throw new IllegalArgumentException("n of " + n
                + " must equal array 2's length " + nums2.length);
        if(nums1.length != m + n) throw new IllegalArgumentException("array 1's length "
                + nums1.length + " must equal m + n");

        int i = 0; // nums1 pointer, if it has a lesser number merge it and i++
        int j = 0; // nums2 pointer, if it has a lesser number merge it and j++
        int k = 0; // merge insertion pointer, k++ when insert happens
        int[] merged = new int[m + n];

        while(k < m + n) {
            boolean nums1Empty = (i >= m);
            boolean nums2Empty = (j >= n);

            if(nums2Empty) {
                merged[k] = nums1[i];
                i++;
                k++;
            }
            else if(nums1Empty) {
                merged[k] = nums2[j];
                j++;
                k++;
            }
            else if(nums1[i] <= nums2[j]) {
                merged[k] = nums1[i];
                i++;
                k++;
            }
            else { // nums2 has a lesser number
                merged[k] = nums2[j];
                j++;
                k++;
            }
        }
        // Copy the sorted merged array back to nums1
        System.arraycopy(merged, 0, nums1, 0, merged.length);

        // remove this to reduce runtime in LeetCode or add it to show result
        System.out.println("Merged Array: " + Arrays.toString(nums1));
    }

    public static void main(String[] args) {

        System.out.println("88. Merge Sorted Array");

        // example 1
        int[] a1 = {2, 0};
        int[] a2 = {1};
        int m1 = 1;
        int n1 = 1;
        System.out.println("\nm = " + m1 + ", n = " + n1);
        System.out.println("Array 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(a2));
        merge(a1, m1, a2, n1);

        // example 2
        int[] b1 = {1};
        int[] b2 = {};
        int m2 = 1;
        int n2 = 0;
        System.out.println("\nm = " + m2 + ", n = " + n2);
        System.out.println("Array 1: " + Arrays.toString(b1));
        System.out.println("Array 2: " + Arrays.toString(b2));
        merge(b1, m2, b2, n2);
    }
}
