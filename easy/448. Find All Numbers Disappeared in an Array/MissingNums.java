import java.util.*;

public class MissingNums {

    public static List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            // get the value
            int num = Math.abs(nums[i]);
            // mark the value's supposed index (1 to n order) with a negative sign
            if(nums[num - 1] > 0) nums[num - 1] = -nums[num - 1];
        }
        for(int i = 0; i < nums.length; i++) {
            // if a value didn't put a mark to its supposed index, it's missing
            if(nums[i] > 0) ans.add(i + 1);
        }
        return ans;
    }

    static void main(String[] args) {

        System.out.println("448. Find All Numbers Disappeared in an Array\n");

        // example 1
        int[] a1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(Arrays.toString(a1));
        System.out.println("Missing: " + findDisappearedNumbers(a1) + "\n");

        // example 2
        int[] a2 = {1, 1};
        System.out.println(Arrays.toString(a2));
        System.out.println("Missing: " + findDisappearedNumbers(a2) + "\n");
    }
}
