package easy;

import java.util.Arrays;

public class ConcatArray {

    public static int[] getConcatenation(int[] nums) {

        int n = nums.length;
        String exp = "array length %,d must be less than 1,073,741,824";
        if(n > 1073741823) throw new IllegalArgumentException(String.format(exp, n));

        int[] ans = new int[n * 2];

        for(int i = 0; i < n; i++) {

            int insert = nums[i];
            ans[i] = insert;
            ans[i + n] = insert;
        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println("1929. Concatenation of Array");

        // example 1
        int[] a1 = {1, 2, 1};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Concatenated Array: " + Arrays.toString(getConcatenation(a1)));

        // example 2
        int[] a2 = {1, 3, 2, 1};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Concatenated Array: " + Arrays.toString(getConcatenation(a2)));
    }
}
