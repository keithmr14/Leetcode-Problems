package easy;

import java.util.Arrays;

public class SortedAndRotated {

    public static boolean check(int[] nums) {

        if(nums.length <= 1) return true;

        int lastNum = nums[0];
        int decrease = 0;

        for(int num : nums) {

            if(num < lastNum) decrease++;

            lastNum = num;
        }

        if(nums[nums.length - 1] > nums[0]) decrease++;

        return (decrease <= 1);
    }

    public static void main(String[] args) {

        System.out.println("1752. Check if Array Is Sorted and Rotated");

        // example 1
        int[] a1 = {3, 4, 5, 1, 2};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Sorted before rotation? " + check(a1));

        // example 2
        int[] a2 = {2, 1, 3, 4};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Sorted before rotation?" + check(a2));
    }
}
