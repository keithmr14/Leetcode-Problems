package medium;

import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int[] colors = new int[3]; // red, white, & blue counter

        for(int num : nums) {

            if(num < 0 || num > 2) throw new IllegalArgumentException("invalid color id");
            colors[num]++;
        }

        int id = 0;

        for(int i = 0; i < nums.length; i++) {

            if(colors[id] == 0) id++;
            if(colors[id] == 0) id++;

            nums[i] = id;
            colors[id]--;
        }
        // remove this to reduce runtime in leetCode or add it to show result
        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {

        System.out.println("75. Sort Colors");

        // example 1
        int[] a1 = {2, 0, 2, 1, 1, 0};
        System.out.println("\nArray: " + Arrays.toString(a1));
        sortColors(a1);

        // example 2
        int[] a2 = {2, 0, 1};
        System.out.println("\nArray: " + Arrays.toString(a2));
        sortColors(a2);
    }
}
