package easy;

import java.util.Arrays;
import static utils.ArrayUtils.*;

public class RemoveDup {

    public static int removeDuplicates(int[] nums) {

        // remove this to reduce runtime in leetCode, but add it outside leetCode
        if(!isNonDecreasingArray(nums))
            throw new IllegalArgumentException("array must be non-decreasing");

        int valid = 1;
        int lastNum = nums[0];

        for(int i = 1; i < nums.length; i++) {

            int num = nums[i];

            if(num > lastNum) {

                nums[valid] = num;
                lastNum = num;
                valid++;
            }
        }

        return valid;
    }

    public static void main(String[] args) {

        System.out.println("26. Remove Duplicates from Sorted Array");

        // example 1
        int[] a1 = {1, 2, 2, 3, 3, 4, 5, 6, 7, 8};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Unique Elements: " + removeDuplicates(a1));

        // example 2
        int[] a2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Unique Elements: " + removeDuplicates(a2));
    }
}
