package easy;

import java.util.Arrays;

public class NumOfSmallerInt {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {

            for(int j = i + 1; j < n; j++) {

                if(nums[i] > nums[j]) ans[i]++;

                else if(nums[i] < nums[j]) ans[j]++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("1365. How Many Numbers Are Smaller Than the Current Number");

        // example 1
        int[] a1 = {8, 1, 2, 2, 3};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("No. of Smaller Int: " + Arrays.toString(smallerNumbersThanCurrent(a1)));

        // example 2
        int[] a2 = {6, 5, 4, 8};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("No. of Smaller Int: " + Arrays.toString(smallerNumbersThanCurrent(a2)));
    }
}
