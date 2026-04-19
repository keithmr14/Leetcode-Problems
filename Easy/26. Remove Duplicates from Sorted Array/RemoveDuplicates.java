import java.util.Arrays;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        int lastNum = nums[0];
        int k = 1; // pointer for the valid elements

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > lastNum) { // ignore same as lastNum
                lastNum = nums[i];
                nums[k] = nums[i]; // put to where k is
                k++;
            }
        }
        System.out.println("NEW: " + Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {

        System.out.println("26. Remove Duplicates from Sorted Array\n");

        // example 1
        int[] a1 = {1, 2, 2, 3, 3, 4, 5, 6, 7, 8};
        System.out.println("ORG: " + Arrays.toString(a1));
        System.out.println(removeDuplicates(a1) + " valid element/s left.\n");

        // example 2
        int[] a2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("ORG: " + Arrays.toString(a2));
        System.out.println(removeDuplicates(a2) + " valid element/s left.\n");
    }
}
