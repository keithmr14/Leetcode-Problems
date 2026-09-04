package easy;

import java.util.*;

public class SeparateDigits {

    public static int[] separateDigits(int[] nums) {

        List<Integer> list = new ArrayList<>(nums.length * 4);

        for (int num : nums) {

            String numStr = String.valueOf(num);

            if (num < 0) throw new IllegalArgumentException("integer elements mustn't be less than 0");

            for (int j = 0; j < numStr.length(); j++) {

                list.add(Character.getNumericValue(numStr.charAt(j)));
            }

            if (list.size() > 1000) throw new IllegalStateException("list size exceeded maximum size of 1000");
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
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
