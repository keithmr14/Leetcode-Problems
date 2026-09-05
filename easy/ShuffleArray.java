package easy;

import java.util.Arrays;

public class ShuffleArray {

    public static int[] shuffle(int[] nums, int n) {

        if(n * 2 != nums.length) throw new IllegalArgumentException(
                "n of " + n + " * 2 must be equal to array length " + nums.length);

        int[] ans = new int[nums.length];
        int a = 0;
        int b = n;

        for(int i = 0; i < nums.length; i++) {

            if(i % 2 == 0) {

                ans[i] = nums[a];
                a++;
            }
            else {
                ans[i] = nums[b];
                b++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

        System.out.println("1470. Shuffle the Array");

        // example 1
        int[] a1 = {2, 5, 1, 3, 4, 7};
        int n1 = 3;
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Shuffled: " + Arrays.toString(shuffle(a1, n1)));

        // example 2
        int[] a2 = {1, 2, 3, 4, 4, 3, 2, 1};
        int n2 = 4;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Shuffled: " + Arrays.toString(shuffle(a2, n2)));
    }
}
