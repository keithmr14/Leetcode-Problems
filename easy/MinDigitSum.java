package easy;

import java.util.Arrays;

public class MinDigitSum {

    public static int minElement(int[] nums) {

        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if(num < 0) throw new IllegalArgumentException("integer "
                    + num + " at index " + i + " mustn't be less than 0");

            int sum = 0;

            while(num > 0) {

                int digit = num % 10;
                sum += digit;
                num /= 10;
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    public static void main(String[] args) {

        System.out.println("3300. Minimum Element After Replacement With Digit Sum");

        // example 1
        int[] a1 = {10, 12, 13, 14};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Min Digit Sum: " + minElement(a1));

        // example 2
        int[] a2 = {1, 2, 3, 4};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Min Digit Sum: " + minElement(a2));
    }
}
