package easy;

import java.util.*;

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {

        if(nums.length < 2) throw new IllegalArgumentException(
                "array length mustn't be less than 2");

        int n = nums.length;
        int[] ans = new int[2];
        Set<Integer> current = new HashSet<>();

        for(int num : nums) {

            if(num < 1 || num > n) throw new IllegalArgumentException(
                    "integer elements must be between 1 and array's length");

            if(current.contains(num)) ans[0] = num;
            else current.add(num);
        }

        if(current.size() != n - 1) throw new IllegalArgumentException(
                "array must have 1 duplicate and 1 missing");


        for(int i = 1; i <= n; i++) {

            if(!current.contains(i)) ans[1] = i;
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println("645. Set Mismatch");

        // example 1
        int[] a1 = {1, 2, 2, 4};
        System.out.println("Array: " + Arrays.toString(a1));
        System.out.println("Duplicate & Missing: " + Arrays.toString(findErrorNums(a1)));

        // example 2
        int[] a2 = {3, 2, 3, 4, 6, 5};
        System.out.println("Array: " + Arrays.toString(a2));
        System.out.println("Duplicate & Missing: " + Arrays.toString(findErrorNums(a2)));
    }
}
