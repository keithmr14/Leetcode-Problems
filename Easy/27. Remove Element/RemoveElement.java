import java.util.Arrays;

class RemoveElem {

    public static int removeElement(int[] nums, int val) {

        int k = 0; // count and insert pointer for numbers != val

        for(int i = 0; i < nums.length; i++) { // for each array element

            if(nums[i] != val) { // compare

                nums[k] = nums[i]; // move
                
                k++; // count and also moves insert index for the next valid number
            }
        } 
        return k; // return how many numbers starting from index 0 are valid
    }

    public static void main(String[] args) {

        System.out.println("27. Remove Element");

        // example 1
        int[] a1 = {0, 1, 0, 2, 0, 3};
        int t1 = 0;
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Remove: " + t1);;
        System.out.println("Number of Valid Elements: " + removeElement(a1, t1));

        // example 2
        int[] a2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int t2 = 2;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Remove: " + t2);;
        System.out.println("Number of Valid Elements: " + removeElement(a2, t2));
    }
}
