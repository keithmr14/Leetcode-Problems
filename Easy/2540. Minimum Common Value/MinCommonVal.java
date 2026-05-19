import java.util.Arrays;

public class MinCommonVal {

    public static int getCommon(int[] nums1, int[] nums2) {

        int i = 0; // nums1 pointer
        int j = 0; // nums2 pointer

        // while both pointers are in bounds
        while(i < nums1.length && j < nums2.length) {

            int n1 = nums1[i];
            int n2 = nums2[j];

            if(n1 == n2) return n1;

            // Given that both arrays are in non-decreasing order,
            // in cases of mismatch, move the smaller pointer forward 
            // to try and match the other value.

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
