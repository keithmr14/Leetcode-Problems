import java.util.Arrays;

public class NoOfSmallerInts {

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];
        // current int pointer
        for(int i = 0; i < n; i++) {
            // compare the next int to subsequent int
            for(int j = i + 1; j < n; j++) {
                // +1 to the less than count
                if(nums[i] > nums[j]) ans[i]++;
                    // +1 to the less than count of the bigger int
                else if(nums[i] < nums[j]) ans[j]++;
            }
        }
        return ans;
    }

    static void main(String[] args) {

        System.out.println("1365. How Many Numbers Are Smaller Than the Current Number\n");

        // example 1
        int[] a1 = {8, 1, 2, 2, 3};
        System.out.println("ARR: " + Arrays.toString(a1));
        System.out.println("ANS: " + Arrays.toString(smallerNumbersThanCurrent(a1)) + "\n");

        // example 1
        int[] a2 = {6, 5, 4, 8};
        System.out.println("ARR: " + Arrays.toString(a2));
        System.out.println("ANS: " + Arrays.toString(smallerNumbersThanCurrent(a2)) + "\n");
    }
}
