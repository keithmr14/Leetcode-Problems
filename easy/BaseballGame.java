package easy;

import java.util.*;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> nums = new Stack<>();
        int finalScore = 0;

        for (String op : operations) {
            switch (op) {
                case "+": // record the sum of the last two num
                    if(nums.size() < 2) throw new IllegalArgumentException("there's not enough scores to add prior to '+'");
                    int top = nums.pop();
                    try {
                        int sum = Math.addExact(nums.peek(), top);
                        nums.push(top);
                        nums.push(sum);
                    }
                    catch(ArithmeticException e) {
                        throw new IllegalArgumentException(top + " + " + nums.peek() + " resulted in integer overflow"); }
                    break;

                case "D": // record 2 times the last num
                    if(nums.isEmpty()) throw new IllegalArgumentException("there's not enough scores to multiply prior to 'D'");
                    try {
                        int product = Math.multiplyExact(nums.peek(), 2);
                        nums.push(product);
                    }
                    catch(ArithmeticException e) {
                        throw new IllegalArgumentException(nums.peek() + " * 2 resulted in an integer overflow"); }
                    break;

                case "C": // invalidate last num
                    if(nums.isEmpty()) throw new IllegalArgumentException("there's not enough scores to invalidate prior to 'C'");
                    nums.pop();
                    break;

                default: // record any number
                    try {
                        nums.push(Integer.parseInt(op));
                    }
                    catch(NumberFormatException e) {
                        throw new IllegalArgumentException("operation \"" + op + "\" is invalid"); }
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
