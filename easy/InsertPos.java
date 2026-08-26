package easy;

import java.util.Arrays;
import static utils.ArrayUtils.isNonDecreasingArray;

public class InsertPos {

    public static int searchInsert(int[] nums, int target) {

        // remove this to reduce runtime in leetCode, but add it outside leetCode
        if(!(isNonDecreasingArray(nums))) throw new IllegalArgumentException("array must be non-decreasing");

        int high = nums.length - 1;
        int low = 0;

        while(low <= high) {

            int mid = (high + low) / 2;
            int midVal = nums[mid];

            if(target == midVal) return mid;

            if(target < midVal) high = mid - 1;
            else low = mid + 1;
        }

        return low;
    }

    public static void main(String[] args) {

        System.out.println("35. Search Insert Position");

        // example 1
        int[] a1 = java.util.stream.IntStream.rangeClosed(1, 10000).toArray();
        int t1 = 7685;

        long start = System.nanoTime();
        int insert = searchInsert(a1, t1);
        long end = System.nanoTime();
        long time = end - start;

        System.out.println("\nArray: [10,000 elements]");
        System.out.println("Target: " + t1);
        System.out.println("Insert Index: " + insert);
        System.out.println("Runtime: " + time + " nanoseconds");

        // example 2
        int[] a2 = {0, 2, 4, 6};
        int t2 = 8;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Target: " + t2);
        System.out.println("Insert Index: " + searchInsert(a2, t2));
    }
}
