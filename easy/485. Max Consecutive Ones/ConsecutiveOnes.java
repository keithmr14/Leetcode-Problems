import java.util.Arrays;

public class ConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int max = 0;
        int i = 0; // current streak

        for (int elem : nums) {
            if (elem == 1) {
                i++;
                max = Math.max(i, max);
            } else i = 0;
        }
        return max;
    }

    static void main(String[] args) {

        System.out.println("485. Max Consecutive Ones\n");

        // example 1
        int[] a1 = {1, 1, 0, 1, 1, 1};
        System.out.println(Arrays.toString(a1));
        System.out.println("Most Consecutive of Is: " + findMaxConsecutiveOnes(a1) + "\n");

        // example 1
        int[] a2 = {1, 0, 1, 1, 0, 1};
        System.out.println(Arrays.toString(a2));
        System.out.println("Most Consecutive of 1s: " + findMaxConsecutiveOnes(a2) + "\n");
    }
}
