import java.util.*;

public class SetMismatch {

    public static int[] findErrorNums(int[] nums) {

        int n = nums.length;
        int[] ans = new int[2];

        // correct elements of 1 to n
        Set<Integer> correct = new HashSet<>(n);
        for(int i = 0; i < n; i++) {
            correct.add(i + 1);
        }

        for(int i = 0; i < n; i++) {
            int num = nums[i];

            if(correct.contains(num)) {
                // number has appeared, remove it from set
                correct.remove(num);

            } else ans[0] = num; // duplicate
        }
        Object[] arr = correct.toArray();
        int last = (int) arr[arr.length - 1];
        ans[1] = last; // lost number

        return ans;
    }

    static void main(String[] args) {

        System.out.println("645. Set Mismatch\n");

        // example 1
        int[] a1 = {1, 2, 2, 4};
        System.out.println(Arrays.toString(a1));
        System.out.println("Duplicate & Missing: " + Arrays.toString(findErrorNums(a1)) + "\n");

        // example 2
        int[] a2 = {2, 2};
        System.out.println(Arrays.toString(a2));
        System.out.println("Duplicate & Missing: " + Arrays.toString(findErrorNums(a2)) + "\n");
    }
}
