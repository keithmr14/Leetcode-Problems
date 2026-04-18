import java.util.Arrays;

class RemoveElement {
    public int removeElement(int[] nums, int val) {

        System.out.println("ORG: " + Arrays.toString(nums));

        int k = -1;
        boolean alrHas = false;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == val && !alrHas) {
                // set k the first time it founds a copy, otherwise ignore
                k = i;
                alrHas = true;
            } else if(nums[i] != val && k != -1) {
                // doesn't copy when no adjustment in position happened
                nums[k] = nums[i];
                k++;
            }
        }
        // when no removal happened (k wasn't set), return nums length
        int result = (k != -1) ? k : nums.length;

        System.out.println("NEW: " + Arrays.toString(nums));
        System.out.println(result + " valid element/s left.\n");

        return result;
    }

    public static void main(String[] args) {

        System.out.println("27. Remove Element\n");

        RemoveElement re = new RemoveElement();

        // example 1
        int[] array = {0, 1, 0, 2, 0, 3};
        re.removeElement(array, 0);

        // example 2
        int[] array2 = {0, 0, 0, 0, 0, 0};
        re.removeElement(array2, 1);
    }
}