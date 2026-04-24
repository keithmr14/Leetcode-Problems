import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        int[] ans = new int[2];
        // <Value, Index>
        HashMap<Integer, Integer> select = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if(select.containsKey(target - num)) { // if any previous, plus the upcoming elem satisfy target
                ans[0] = select.get(target - num);
                ans[1] = i;
                return ans;
            }
            // put at the end to avoid upcoming elem using itself twice
            // if key already exist, but sum of both != target, it's safe to overwrite it
            select.put(nums[i], i);
        }
        return ans; // shouldn't happen based on exactly one solution constraint
    }

    static void main(String[] args) {

        System.out.println("1. Two Sum\n");

        // example 1
        int[] a1 = {2, 7, 11, 15};
        int t1 = 9;
        System.out.println(Arrays.toString(a1));
        System.out.println("Target: " + t1);
        System.out.println("Indexes: " + Arrays.toString(twoSum(a1, t1)) + "\n");

        // example 2
        int[] a2 = {-3, 4, 3, 90};
        int t2 = 0;
        System.out.println(Arrays.toString(a2));
        System.out.println("Target: " + t2);
        System.out.println("Indexes: " + Arrays.toString(twoSum(a2, t2)) + "\n");
    }
}
