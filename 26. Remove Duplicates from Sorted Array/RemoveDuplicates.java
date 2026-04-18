import java.util.Arrays;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {

        System.out.println("ORG: " + Arrays.toString(nums));

        int lastNum = nums[0];
        int k = 1; // also acts as to where next num will be put at

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > lastNum) { // ignore same as lastNum
                lastNum = nums[i];
                nums[k] = nums[i]; // put to where k is
                k++;
            }
        }

        System.out.println("NEW: " + Arrays.toString(nums));
        System.out.println(k + " valid element/s left.\n");

        return k;
    }

    public static void main(String[] args) {

        System.out.println("26. Remove Duplicates from Sorted Array\n");

        RemoveDuplicates rev = new RemoveDuplicates();

        // example 1
        int[] array = {1, 2, 2, 3, 3, 4, 5, 6, 7, 8};
        rev.removeDuplicates(array);

        // example 2
        int[] array2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        rev.removeDuplicates(array2);
    }
}
