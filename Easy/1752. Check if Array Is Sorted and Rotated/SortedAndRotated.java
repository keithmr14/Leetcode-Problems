import java.util.Arrays;

public class SortedAndRotated {

    public static boolean check(int[] nums) {

        int n = nums.length;
        int lastNum = nums[0];
        boolean looped = false;
        boolean rotated = false;

        // starts at i = 1 and ends at i = 0
        for(int i = 1; i < n; i++) {

            // after were done with index n - 1, set i = 0,
            // and n = 1 to make sure loop stops after this
            if(looped) { i = 0; n = 1; }

            int num = nums[i];

            // if non-decreasing order, continue
            if(lastNum <= num) lastNum = num;

            // if it's the first time decreasing, continue
            else if(!rotated) { lastNum = num; rotated = true; }

            else return false;

            // if at the last index, make loop run one last time and at the index 0
            if(i == n - 1 && !looped) { looped = true; n++; }
        }
        // after checking all indexes and it didn't decrease twice, return true
        return true; 
    }

    public static void main(String[] args) {

        System.out.println("1752. Check if Array Is Sorted and Rotated");

        // example 1
        int[] a1 = {3, 4, 5, 1, 2};
        System.out.println("\nARR: " + Arrays.toString(a1));
        System.out.println("Sorted & Rotated? " + check(a1));

        // example 2
        int[] a2 = {2, 1, 3, 4};
        System.out.println("\nARR: " + Arrays.toString(a2));
        System.out.println("Sorted & Rotated? " + check(a2));
    }
}
