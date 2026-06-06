import java.util.Arrays;

public class ShuffleArray {

    public static int[] shuffle(int[] nums, int n) {

        int size = nums.length;
        int[] ans = new int[size];

        int i = 0; // used to choose what'll be inserted
        int j = 0; // insert pointer

        while(i < n) {

            ans[j] = nums[i];
            j++;
            ans[j] = nums[n + i];
            j++;
            i++;
        }
        return ans;
    }

    static void main(String[] args) {

        System.out.println("1470. Shuffle the Array\n");

        // example 1
        int[] a1 = {2, 5, 1, 3, 4, 7};
        System.out.println("ORG: " + Arrays.toString(a1));
        System.out.println("NEW: " + Arrays.toString(shuffle(a1, 3)) + "\n");

        // example 2
        int[] a2 = {1, 2, 3, 4, 4, 3, 2, 1};
        System.out.println("ORG: " + Arrays.toString(a2));
        System.out.println("NEW: " + Arrays.toString(shuffle(a2, 4)) + "\n");
    }
}