package medium;

import java.util.Arrays;

public class MaxElemDecrease {

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        if(arr.length == 0) return 0;

        int max = 1;
        Arrays.sort(arr);

        if(arr[0] < 1) throw new IllegalArgumentException("integer " + arr[0] + " must be greater than or equal to 1");
        
        arr[0] = 1;

        for(int i = 1; i < arr.length; i++) {

            int prev = arr[i - 1];
            int curr = arr[i];

            if(curr > prev) {
                arr[i] = prev + 1;
                max = Math.max(max, prev + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println("1846. Maximum Element After Decreasing and Rearranging");

        // example 1
        int[] a1 = {2, 2, 1, 2, 1};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Highest Number: " + maximumElementAfterDecrementingAndRearranging(a1));

        // example 2
        int[] a2 = {100, 1, 1000};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Highest Number: " + maximumElementAfterDecrementingAndRearranging(a2));
    }
}
