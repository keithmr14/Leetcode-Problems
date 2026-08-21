package easy;

import java.util.Arrays;

public class LeftRightSumDiff {

    public static int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int[] diff = new int[n];

        int left = 0;
        // left traverse to record left sum
        for(int i = 0; i < n; i++) {

            int num = nums[i];
            diff[i] = left;

            if(num < 1) throw new IllegalArgumentException("integer "
                    + num + " at index " + i + " must be greater than or equal to 1");
            if(i == n - 1) break;
            try {
                left = Math.addExact(left, num);
            }
            catch(ArithmeticException e) {
                throw new ArithmeticException("exception from left sum "
                        + left + " + " + num + " due to integer overflow at index " + i); }
        }

        int right = 0;
        // right traverse, subtract right to left sum, then take absolute value
        for(int i = n - 1; i >= 0; i--) {

            diff[i] = Math.abs(diff[i] - right);
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
