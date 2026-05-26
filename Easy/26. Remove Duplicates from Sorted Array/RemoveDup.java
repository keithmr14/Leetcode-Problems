import java.util.Arrays;

public class RemoveDup {

    public static int removeDuplicates(int[] nums) {

        int k = 1; // pointer for the valid elements

        // set first elem as lastNum and start comparing at index 1
        int lastNum = nums[0];

        for(int i = 1; i < nums.length; i++) {

            int num = nums[i];

            // Ignore num if it's the same as lastNum, and if not,
            // move it to where it should be (k).
            // Only include unique numbers to k.
            if(num > lastNum) {

                nums[k] = num;
                lastNum = num;
                k++;
            }
        }

        System.out.println("NEW: " + Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {

        System.out.println("26. Remove Duplicates from Sorted Array");

        // example 1
        int[] a1 = {1, 2, 2, 3, 3, 4, 5, 6, 7, 8};
        System.out.println("\nARR: " + Arrays.toString(a1));
        System.out.println("Unique Elements (k): " + removeDuplicates(a1));

        // example 2
        int[] a2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\nARR: " + Arrays.toString(a2));
        System.out.println("Unique Elements (k): " + removeDuplicates(a2));
    }
}
