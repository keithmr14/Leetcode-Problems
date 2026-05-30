import java.util.Arrays;

public class PlusOne {

    public static int[] plusOne(int[] digits) {

        int lastDig = digits.length - 1; // last digit index

        digits[lastDig]++; // initiate first plus before deciding to carry

        while(lastDig >= 0) { // continue until we checked the first digit

            if(digits[lastDig] == 10) { // in need of carry

                digits[lastDig] = 0; // set as 0

                // if there's a next digit to add carry to, plus 1 to that digit
                if(lastDig > 0) digits[lastDig - 1]++;

                lastDig--; // check the next digit
            }
            // return at this point if there's no need to increase array size
            else return digits;
        }

        // if left with a leading zero, create a new array (sized n + 1)
        int[] incSize = new int[digits.length + 1];
        incSize[0] = 1; // the first digit carries 1

        // copy old array and shift them right by 1
        System.arraycopy(digits, 0, incSize, 1, digits.length);

        return incSize; // return new array
    }

    public static void main(String[] args) {

        System.out.println("66. Plus One");

        // example 1
        int[] a1 = {1, 2, 3};
        System.out.println("\nAdd 1: " + Arrays.toString(a1));
        System.out.println("Sum: " + Arrays.toString(plusOne(a1)));

        // example 2
        int[] a2 = {9};
        System.out.println("\nAdd 1: " + Arrays.toString(a2));
        System.out.println("Sum: " + Arrays.toString(plusOne(a2)));
    }
}
