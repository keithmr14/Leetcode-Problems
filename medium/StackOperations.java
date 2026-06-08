package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StackOperations {

    public static List<String> buildArray(int[] target, int n) {

        if(n < 1) throw new IllegalArgumentException("n is invalid");

        List<String> operations = new ArrayList<>();
        int stream = 1;

        for(int i = 0; i < target.length && stream <= n; i++) {

            if(target[i] > n) throw new IllegalArgumentException("target is unattainable");

            if(target[i] == stream) {
                operations.add("Push");
                stream++;
            }
            else {
                operations.add("Push");
                operations.add("Pop");
                stream++;
                i--; // stay at current target until it's solved
            }
        }
        return operations;
    }

    public static void main(String[] args) {

        System.out.println("1441. Build an Array With Stack Operations");

        // example 1
        int[] a1 = {1, 3};
        int n1 = 3;
        System.out.println("\nTarget: " + Arrays.toString(a1) + " n = " + n1);
        System.out.println("Stack Operations: " + buildArray(a1, n1));

        // example 2
        int[] a2 = {1, 2};
        int n2 = 4;
        System.out.println("\nTarget: " + Arrays.toString(a2) + " n = " + n2);
        System.out.println("Stack Operations: " + buildArray(a2, n2));
    }
}
