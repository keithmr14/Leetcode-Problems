package easy;

import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        if(digits.length == 0) throw new IllegalArgumentException("array mustn't be empty");

        for(int i = digits.length - 1; i >= 0; i--) {

            int dig = digits[i];

            if(dig > 9 || dig < 0) throw new IllegalArgumentException("integer " + dig
                    + " at index " + i + " must be between 0 and 9");

            digits[i]++;

            if(digits[i] == 10) digits[i] = 0;

            else return digits;
        }

        int[] incSize = new int[digits.length + 1];
        incSize[0] = 1;

        System.arraycopy(digits, 0, incSize, 1, digits.length);

        return incSize;
    }

    public static void main(String[] args) {

        System.out.println("66. Plus One");

        // example 1
        int[] a1 = {1, 2, 3};
        System.out.println("\nAdd 1: " + Arrays.toString(a1));
        System.out.println("Sum: " + Arrays.toString(plusOne(a1)));

        // example 2
        int[] a2 = {9};
        System.out.println("\nAdd 1: " + Arrays.toString(a2));
        System.out.println("Sum: " + Arrays.toString(plusOne(a2)));
    }
}
