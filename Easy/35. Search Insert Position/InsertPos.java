import java.util.Arrays;

public class InsertPos {

    public static int searchInsert(int[] nums, int target) {

        // search range indexes of a binary search
        int high = nums.length - 1;
        int low = 0;

        // continue until search range = 0
        while(low <= high) {

            // find the array's middle index (rounded-down)
            int mid = (high + low) / 2;
            int midVal = nums[mid];

            if(target == midVal) return mid;

            // Cut the search range in half (including midVal
            // because it's != to target already).
            if(target < midVal) high = mid - 1;

            // Insert position will also be at mid + 1 when low 
            // == high and midVal != target.
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

        System.out.println("\nArray: [10,000 elements] Target: " + t1);
        System.out.println("Insert Index: " + insert);
        System.out.println("Runtime: " + time + " nanoseconds");

        // example 2
        int[] a2 = {0, 2, 4, 6};
        int t2 = 8;
        System.out.println("\nArray: " + Arrays.toString(a2) + " Target: " + t2);
        System.out.println("Insert Index: " + searchInsert(a2, t2));
    }
}
