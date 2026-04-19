import java.util.Arrays;

class RemoveElement {

    public static int removeElement(int[] nums, int val) {

        int k = -1; // pointer for the valid elements
        boolean alrHas = false;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val && !alrHas) {

                k = i; // set k the first time it founds a copy, otherwise ignore
                alrHas = true;

            } else if(nums[i] != val && k != -1) {

                nums[k] = nums[i]; // doesn't copy when no adjustment in position happened
                k++;
            }
        }
        // when no removal happened (k wasn't set), return nums length
        int result = (k != -1) ? k : nums.length;

        System.out.println("NEW: " + Arrays.toString(nums));
        return k;
    }

    public static void main(String[] args) {

        System.out.println("27. Remove Element\n");

        // example 1
        int[] a1 = {0, 1, 0, 2, 0, 3};
        System.out.println("ORG: " + Arrays.toString(a1));
        System.out.println("Remove: " + 0);;
        System.out.println(removeElement(a1, 0) + " valid element/s left.\n");

        // example 2
        int[] a2 = {0, 0, 0, 0, 0, 0};
        System.out.println("ORG: " + Arrays.toString(a2));
        System.out.println("Remove: " + 1);
        System.out.println(removeElement(a2, 1) + " valid element/s left.\n");
    }
}