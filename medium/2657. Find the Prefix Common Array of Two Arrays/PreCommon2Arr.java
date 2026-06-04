import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PreCommon2Arr {

    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n = A.length; // given that both has the same length
        int common = 0; // number of common numbers so far
        int[] prefix = new int[n]; // number of common so far for each index

        // given that 1 <= A[i], B[i] <= n, prevNums.length == n
        Set<Integer> prevNums = new HashSet<>(n); // unique numbers

        for(int i = 0; i <  n; i++) { // for each array element

            int a = A[i];
            int b = B[i];
            // if 'a' exists in previous or current index, common++
            if(prevNums.contains(a) || a == b) common++;
            else prevNums.add(a); // else, record the unique number

            // if 'b' exists in previous or current index, common++
            if(prevNums.contains(b)) common++;
            else prevNums.add(b); // else, record the unique number

            prefix[i] = common;
        }

        return prefix;
    }

    public static void main(String[] args) {

        System.out.println("2657. Find the Prefix Common Array of Two Arrays");

        // example 1
        int[] a1 = {1, 3, 2, 4};
        int[] b1 = {3, 1, 2, 4};
        System.out.println("\nArray 1: " + Arrays.toString(a1));
        System.out.println("Array 2: " + Arrays.toString(b1));
        System.out.println("Prefix Array: " +
                Arrays.toString(findThePrefixCommonArray(a1, b1)));

        // example 2
        int[] a2 = {2, 3, 1};
        int[] b2 = {3, 1, 2};
        System.out.println("\nArray 1: " + Arrays.toString(a2));
        System.out.println("Array 2: " + Arrays.toString(b2));
        System.out.println("Prefix Array: " +
                Arrays.toString(findThePrefixCommonArray(a2, b2)));
    }
}
