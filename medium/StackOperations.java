package medium;

import java.util.*;

public class StackOperations {

    public static List<String> buildArray(int[] target, int n) {

        if(n < 1) throw new IllegalArgumentException("n of " + n + " must be greater than or equal to 1");

        List<String> operations = new ArrayList<>();
        int stream = 1;

        for(int i = 0; i < target.length && stream <= n; i++) {

            int t = target[i];

            if(t < 1 || t > n) throw new IllegalArgumentException("target " + t + " at index "
                    + i + " must be between 1 and n of " + n);
            if(t < stream) throw new IllegalArgumentException("target " + t + " at index "
                    + i + " breaks strictly increasing sequence");

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
        int[] t1 = {1, 3};
        int n1 = 3;
        System.out.println("\nStack Height: " + n1 + "    Target: " + Arrays.toString(t1));
        System.out.println("Stack Operations: " + buildArray(t1, n1));

        // example 2
        int[] t2 = {1, 2};
        int n2 = 4;
        System.out.println("\nStack Height: " + n2 + "    Target: " + Arrays.toString(t2));
        System.out.println("Stack Operations: " + buildArray(t2, n2));
    }
}
