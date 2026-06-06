import java.util.Arrays;

public class ConcatArray {

    public static int[] getConcatenation(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n * 2];

        for(int i = 0; i < n; i++) {

            int insert = nums[i];
            ans[i] = insert;
            ans[i + n] = insert;
        }

        return ans;
    }

    static void main(String[] args) {

        System.out.println("1929. Concatenation of Array\n");

        // example 1
        int[] a1 = {1, 2, 1};
        System.out.println("ORG: " + Arrays.toString(a1));
        System.out.println("NEW: " + Arrays.toString(getConcatenation(a1)) + "\n");

        // example 2
        int[] a2 = {1, 3, 2, 1};
        System.out.println("ORG: " + Arrays.toString(a2));
        System.out.println("NEW: " + Arrays.toString(getConcatenation(a2)) + "\n");
    }
}
