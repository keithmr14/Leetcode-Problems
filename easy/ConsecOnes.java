package easy;

import java.util.Arrays;

public class ConsecOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int i = 0; // current streak

        for (int elem : nums) {
            if (elem == 1) {
                i++;
                max = Math.max(i, max);
            } else i = 0;
        }
        return max;
    }

    public static void main(String[] args) {

        System.out.println("485. Max Consecutive Ones");

        // example 1
        int[] a1 = {1, 1, 0, 1, 1, 1};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Max Streak of 1s: " + findMaxConsecutiveOnes(a1));

        // example 2
        int[] a2 = {1, 0, 1, 1, 0, 1};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Max Streak of 1s: " + findMaxConsecutiveOnes(a2));
    }
}
