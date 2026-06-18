package easy;

import java.util.Arrays;

class RemoveElem {

    public static int removeElement(int[] nums, int removeThis) {

        int saveThis = 0;

        for(int i = 0; i < nums.length; i++) {

            if(nums[i] != removeThis) {
                // only when it sees removeThis will saveThis != i
                nums[saveThis] = nums[i];
                saveThis++;
            }
        }

        return saveThis;
    }

    public static void main(String[] args) {

        System.out.println("27. Remove Element");

        // example 1
        int[] a1 = {0, 1, 0, 2, 0, 3};
        int t1 = 0;
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Remove Element: " + t1);;
        System.out.println("Number of Elements Left: " + removeElement(a1, t1));

        // example 2
        int[] a2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int t2 = 2;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Remove Element: " + t2);;
        System.out.println("Number of Elements Left: " + removeElement(a2, t2));
    }
}
