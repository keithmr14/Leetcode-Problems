import java.util.Arrays;

public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0; // nums1 pointer, if it has a lesser number merge it and i++
        int j = 0; // nums2 pointer, if it has a lesser number merge it and j++

        int[] merge = new int[m + n];
        int k = 0; // merge insertion pointer, k++ when insert happens

        while(k < m + n) {
            boolean empty1 = (i >= m);
            boolean empty2 = (j >= n);

            if(empty2) {
                // if nums2 ran out of numbers, merge the rest of nums1
                merge[k] = nums1[i];
                i++;
                k++;
            }
            else if(empty1) {
                // if nums1 ran out of numbers, merge the rest of nums2
                merge[k] = nums2[j];
                j++;
                k++;
            }
            else if(nums1[i] <= nums2[j]) {
                // compare and if nums1 has a lesser number, merge it first
                merge[k] = nums1[i];
                i++;
                k++;
            }
            else { // nums2 has a lesser number, merge it first
                merge[k] = nums2[j];
                j++;
                k++;
            }
        }
        // Copy the sorted merge array back to nums1
        System.arraycopy(merge, 0, nums1, 0, merge.length);

        System.out.println("SUM: " + Arrays.toString(nums1) + "\n");
    }

    public static void main(String[] args) {

        System.out.println("88. Merge Sorted Array\n");

        // example 1
        int[] a1 = {2, 0};
        int[] a2 = {1};
        System.out.println("OP1: " + Arrays.toString(a1));
        System.out.println("OP2: " + Arrays.toString(a2));
        merge(a1, 1, a2, 1);

        // example 2
        int[] b1 = {1};
        int[] b2 = {};
        System.out.println("OP1: " + Arrays.toString(b1));
        System.out.println("OP2: " + Arrays.toString(b2));
        merge(b1, 1, b2, 0);
    }
}
