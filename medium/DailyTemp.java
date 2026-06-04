package medium;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemp {

    public static int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>(); // stack of waiting temperature indices

        for(int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while(!stack.empty()) {
                int topI = stack.peek();
                // if temp is not > than peek, it is not > the rest of the stack
                if(temp <= temperatures[topI]) break;
                // calculate wait time, pop, & see if temp is still > the rest of the stack
                temperatures[topI] = i - topI;
                stack.pop();
            }
            stack.push(i); // when all/no comparison done
        }
        // set wait time to 0 for all remaining index in the stack
        while(!stack.empty()) temperatures[stack.pop()] = 0;

        return temperatures; // updated as wait time for all temperatures
    }

    public static void main(String[] args) {

        System.out.println("739. Daily Temperatures");
        // example 1
        int[] a1 = {2, 1, 2, 3};
        System.out.println("\nTemperature: " + Arrays.toString(a1));
        System.out.println("Wait Time: " + Arrays.toString(dailyTemperatures(a1)));
        // example 2
        int[] a2 = {30, 40, 50, 60};
        System.out.println("\nTemperature: " + Arrays.toString(a2));
        System.out.println("Wait Time: " + Arrays.toString(dailyTemperatures(a2)));
    }
}
