package easy;

import java.util.*;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        int[] ans = {-1, -1};
        HashMap<Integer, Integer> prev = new HashMap<>(); // <Value, Index>

        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];
            try {
                int pair = Math.subtractExact(target, num);

                if(prev.containsKey(pair)) {

                    ans[0] = prev.get(pair);
                    ans[1] = i;
                    return ans;
                }
            }
            catch(ArithmeticException e) { throw new ArithmeticException(
                    "stop playing with integer max/min values"); }

            prev.put(nums[i], i);
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("1. Two Sum");

        // example 1
        int[] a1 = {2, 2147483646};
        int t1 = -2147483648;
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Target: " + t1);
        System.out.println("Indexes: " + Arrays.toString(twoSum(a1, t1)));

        // example 2
        int[] a2 = {-3, 4, 3, 90};
        int t2 = 0;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Target: " + t2);
        System.out.println("Indexes: " + Arrays.toString(twoSum(a2, t2)));
    }
}