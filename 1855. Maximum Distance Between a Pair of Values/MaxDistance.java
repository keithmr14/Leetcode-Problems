import java.util.Arrays;

public class MaxDistance {

    public static int maxDistance(int[] nums1, int[] nums2) {

        int maxDist = 0;
        int i = 0;
        int j = 1; // doesn't let i == j for distance is 0

        // discontinue if all possible distance is already less than what we already found
        while(maxDist < nums2.length - i + 1 && i < nums1.length && j < nums2.length) {

            if(nums1[i] <= nums2[j]) {
                // try if next nums2 elem is still less than nums1 element
                maxDist = Math.max(j - i, maxDist);;
                j++;
            } else {
                i++;
                j++;
            }
        }
        return maxDist;
    }

    public static void main(String[] args) {

        System.out.println("1855. Maximum Distance Between a Pair of Values\n");

        // example 1
        int[] a1 = {55, 30, 5, 4, 2};
        int[] a2 = {100, 20, 10, 10, 5};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println("Max Distance: " + maxDistance(a1, a2) + "\n");

        // example 2
        int[] b1 = {2, 2, 2};
        int[] b2 = {10, 10, 1};
        System.out.println(Arrays.toString(b1));
        System.out.println(Arrays.toString(b2));
        System.out.println("Max Distance: " + maxDistance(a1, a2) + "\n");
    }
}
