import java.util.ArrayList;
import java.util.Arrays;

public class SeparateDigits {

    public static int[] separateDigits(int[] nums) {

        // separated digits result, expect 5x length
        ArrayList<Integer> list = new ArrayList<>(nums.length * 5);

        for(int num : nums) { // for each number in the array

            boolean first = true; // a digit can equal zero only if !lead digit

            if(num / 100000 != 0) {

                list.add(num / 100000);
                num %= 100000;
                first = false;
            }
            if(num / 10000 != 0 || !first) {

                list.add(num / 10000);
                num %= 10000;
                first = false;
            }
            if(num / 1000 != 0 || !first) {

                list.add(num / 1000);
                num %= 1000;
                first = false;
            }
            if(num / 100 != 0 || !first) {

                list.add(num / 100);
                num %= 100;
                first = false;
            }
            if(num / 10 != 0 || !first) {

                list.add(num / 10);
                num %= 10;
            }
            list.add(num);
        }
        // convert list to array then return
        return list.stream().mapToInt(i -> i).toArray();
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
