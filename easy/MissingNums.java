package easy;

import java.util.*;

public class MissingNums {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] < 1) throw new IllegalArgumentException("integer "
                    + nums[i] + " at index " + i + " mustn't be less than 1");
        }

        for(int i = 0; i < nums.length; i++) {

            int num = Math.abs(nums[i]);

            if(nums[num - 1] > 0) nums[num - 1] = -nums[num - 1];
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("448. Find All Numbers Disappeared in an Array");

        // example 1
        int[] a1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Missing: " + findDisappearedNumbers(a1));

        // example 2
        int[] a2 = {1, 1};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Missing: " + findDisappearedNumbers(a2));
    }
}
