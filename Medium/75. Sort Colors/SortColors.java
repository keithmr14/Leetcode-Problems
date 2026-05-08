import java.io.PrintStream;
import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int[] colors = new int[3]; // red, white, blue unsorted counter

        for(int num : nums) {

            colors[num]++; // count color appearance
        }

        for(int i = 0; i < nums.length; i++) {

            int color = 0; // assume red exists

            if(colors[0] == 0) { // if red count = 0

                color = 1; // change color to white

                // if white count = 0, change color to blue
                if(colors[1] == 0) color = 2;
            }

            nums[i] = color; // put the right color into place
            colors[color]--; // reduce unsorted count
        }

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
