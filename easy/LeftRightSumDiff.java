package easy;

import java.util.Arrays;

public class LeftRightSumDiff {

    public static int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int[] diff = new int[n];

        int left = 0;
        // left traverse to record left sum
        for(int i = 0; i < n; i++) {
            diff[i] = left;
            try {
                left = Math.addExact(left, nums[i]);
            }
            catch(ArithmeticException e) {
                throw new IllegalArgumentException("sum of the elements causes an integer overflow"); }
        }

        int right = 0;
        // right traverse and subtract right to left sum (then abs)
        for(int i = n - 1; i >= 0; i--) {
            try {
                diff[i] = Math.absExact(Math.subtractExact(diff[i], right));
            }
            catch(ArithmeticException e) {
                throw new IllegalArgumentException("difference of right and left sum causes an integer overflow"); }

            right += nums[i];
        }

        return diff;
    }

    public static void main(String[] args) {

        System.out.println("2574. Left and Right Sum Differences");

        // example 1
        int[] a1 = {10, 4, 8, 3};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Differences: " + Arrays.toString(leftRightDifference(a1)));

        // example 2
        int[] a2 = {1, 1, 1, 1};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Differences: " + Arrays.toString(leftRightDifference(a2)));
    }
}
