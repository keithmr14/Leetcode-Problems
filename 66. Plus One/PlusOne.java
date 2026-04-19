import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        // start from the last digit
        int lastDig = digits.length - 1;

        digits[lastDig]++; // initiate first plus before deciding to carry

        while(lastDig != -1) { // while array index is >= 0

            if(digits[lastDig] == 10) {

                digits[lastDig] = 0;

                // if there's a corresponding elem to add carry
                if(lastDig != 0) digits[lastDig - 1]++;

                lastDig--;
                
            } else return digits;
            // return at this point if there's no need to increase array size
        }

        // if left with a leading zero, increase array size and start with 1
        int[] incSize = new int[digits.length + 1];
        incSize[0] = 1;

        // copy old array numbers adjusting to right by 1 unit
        System.arraycopy(digits, 0, incSize, 1, digits.length);

        return incSize;
    }

    public static void main(String[] args) {

        System.out.println("66. Plus One\n");

        // example 1
        int[] array = {1, 2, 3};
        System.out.println(Arrays.toString(array) + " + 1");
        int[] output = plusOne(array);
        System.out.println("= " + Arrays.toString(output) + "\n");

        // example 1
        int[] array2 = {9};
        System.out.println(Arrays.toString(array2) + " + 1");
        int[] output2 = plusOne(array2);
        System.out.println("= " + Arrays.toString(output2) + "\n");
    }
}
