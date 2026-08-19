package easy;

import java.util.Arrays;

public class HighestAltitude {

    public static int largestAltitude(int[] gains) {

        int maxAlt = 0;
        int currAlt = 0;

        for(int i = 0; i < gains.length; i++) {

            int gain = gains[i];
            try {
                currAlt = Math.addExact(currAlt, gain);
            }
            catch(ArithmeticException e) {
                throw new ArithmeticException("exception from current altitude "
                        + currAlt + " + gain " + gain + " due to integer overflow at index " + i); }

            maxAlt = Math.max(currAlt, maxAlt);
        }

        return maxAlt;
    }

    public static void main(String[] args) {

        System.out.println("1732. Find the Highest Altitude");

        // example 1
        int[] a1 = {-5, 1, 5, 0, -7};
        System.out.println("\nAltitude Gains: " + Arrays.toString(a1));
        System.out.println("Highest Altitude: " + largestAltitude(a1));

        // example 2
        int[] a2 = {-4, -3, -2, -1, 4, 3, 2};
        System.out.println("\nAltitude Gains: " + Arrays.toString(a2));
        System.out.println("Highest Altitude: " + largestAltitude(a2));
    }
}
