import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparateDigits {

    public static int[] separateDigits(int[] nums) {

        // separated digits result, expect 4x length
        List<Integer> list = new ArrayList<>(nums.length * 4);

        for(int num : nums) { // for each number in the array

            char placeVal = 'z';
            // based on how many digit num has, start dividing
            // and getting those number in its specific place value

            if(num >= 100000) placeVal = 'a';

            else if(num >= 10000) placeVal = 'b';

            else if(num >= 1000) placeVal = 'c';

            else if(num >= 100) placeVal = 'd';

            else if(num >= 10) placeVal = 'e';

            switch(placeVal) {

                case 'a': // get the digit at 100,000 place value
                    list.add(num / 100000);
                    num %= 100000;
                case 'b': // get the digit at 10,000 place value
                    list.add(num / 10000);
                    num %= 10000;
                case 'c': // get the digit at 1,000 place value
                    list.add(num / 1000);
                    num %= 1000;
                case 'd': // get digit at 100 place value
                    list.add(num / 100);
                    num %= 100;
                case 'e': // get digit at 10 place value
                    list.add(num / 10);
                    num %= 10;
                default: // last digit always exist at 1 place value
                    list.add(num);
            }
        }
        int[] result = new int[list.size()];
        // convert arraylist to array
        for (int i = 0; i < list.size(); i++) { result[i] = list.get(i); }

        return result;
    }

    public static void main(String[] args) {

        System.out.println("2553. Separate the Digits in an Array");

        // example 1
        int[] a1 = {1001};
        System.out.println("\nARR: " + Arrays.toString(a1));
        System.out.println("SEP: " + Arrays.toString(separateDigits(a1)));

        // example 2
        int[] a2 = {13, 25, 83, 77};
        System.out.println("\nARR: " + Arrays.toString(a2));
        System.out.println("SEP: " + Arrays.toString(separateDigits(a2)));
    }
}
