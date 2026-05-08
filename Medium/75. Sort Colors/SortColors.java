import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int[] colors = new int[3]; // red, white, blue unsorted counter

        for(int num : nums) { colors[num]++; } // count color appearance

        int red = colors[0];
        int white = colors[1];

        for(int i = 0; i < red; i++) { nums[i] = 0; } // place reds

        for(int i = red; i < red + white; i++) { nums[i] = 1; } // place whites

        for(int i = red + white; i < nums.length; i++) { nums[i] = 2; } // place blues

        System.out.println("Sorted: " + Arrays.toString(nums));
    }

    public static void main(String[] args) {

        System.out.println("75. Sort Colors");

        // example 1
        int[] a1 = {2, 0, 2, 1, 1, 0};
        System.out.println("\n" + Arrays.toString(a1));
        sortColors(a1);

        // example 2
        int[] a2 = {2, 0, 1};
        System.out.println("\n" + Arrays.toString(a2));
        sortColors(a2);
    }
}
