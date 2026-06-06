import java.util.Arrays;

public class MinDigitSum {

    public static int minElement(int[] nums) {

        // for each number in the array, take the sum of their own digits
        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int sum = 0;

            while(num > 0) { // while there's a digit to add

                int digit = num % 10; // last digit of num
                sum += digit; // add last digit to the sum
                num /= 10; // remove the last digit
            }

            nums[i] = sum; // each sum is inserted to the unused space of nums
        }

        int min = nums[0]; // set the 1st sum as the default minimum

        for(int i = 1; i < nums.length; i++) {
            // compare every sum and find the smallest
            min = Math.min(min, nums[i]);
        }

        return min; // return the smallest sum
    }

    public static void main(String[] args) {

        System.out.println("3300. Minimum Element After Replacement With Digit Sum");

        // example 1
        int[] a1 = {10, 12, 13, 14};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Minimum Digit Sum: " + minElement(a1));

        // example 2
        int[] a2 = {1, 2, 3, 4};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Minimum Digit Sum: " + minElement(a2));
    }
}
