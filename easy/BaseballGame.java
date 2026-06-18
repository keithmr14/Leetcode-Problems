package easy;

import java.util.Arrays;
import java.util.Stack;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> nums = new Stack<>();
        int finalScore = 0;

        for (String op : operations) {
            switch (op) {
                case "+": // record the sum of the last two num
                    int top = nums.pop(); 
                    int sum = nums.peek() + top;
                    nums.push(top);
                    nums.push(sum);
                    break;

                case "D": // record 2 times the last num
                    nums.push(nums.peek() * 2);
                    break;

                case "C": // invalidate last num
                    nums.pop();
                    break;

                default: // record any number

                    try { Integer.parseInt(op); }

                    catch(NumberFormatException e) {
                        throw new IllegalArgumentException("operation \"" + op + "\" is invalid"); }

                    nums.push(Integer.parseInt(op));
            }
        }
        // add all the scores
        while(!nums.empty()) finalScore += nums.pop();

        return finalScore;
    }

    public static void main(String[] args) {

        System.out.println("682. Baseball Game");

        // example 1
        String[] a1 = {"5", "2", "C", "D", "+"};
        System.out.println("\nOperations: " + Arrays.toString(a1));
        System.out.println("Final Score: " + calPoints(a1));

        // example 2
        String[] a2 = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println("\nOperations: " + Arrays.toString(a2));
        System.out.println("Final Score: " + calPoints(a2));
    }
}
