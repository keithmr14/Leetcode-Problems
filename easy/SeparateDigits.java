package easy;

import java.util.*;

public class SeparateDigits {

    public static int[] separateDigits(int[] nums) {

        int digits = 0;

        for (int num : nums) {

            if (num < 0) throw new IllegalArgumentException("integer elements mustn't be less than 0");

            String numStr = String.valueOf(num);
            digits += numStr.length();

            if(digits > 10_000_000) throw new IllegalStateException(
                    "result array length exceeded maximum size of 10,000,000");
        }

        int[] result = new int[digits];
        int i = 0;

        for (int num : nums) {

            String numStr = String.valueOf(num);

            for (int j = 0; j < numStr.length(); j++) {

                result[i] = Character.getNumericValue(numStr.charAt(j));
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("2553. Separate the Digits in an Array");

        // example 1
        int[] a1 = {1001};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Separated: " + Arrays.toString(separateDigits(a1)));

        // example 2
        int[] a2 = {13, 25, 83, 77};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Separated: " + Arrays.toString(separateDigits(a2)));
    }
}
