package easy;

import java.util.*;

public class BaseballGame {

    public static int calPoints(String[] operations) {

        Stack<Integer> nums = new Stack<>();


        for (int i = 0; i < operations.length; i++) {

            String op = operations[i];
            IllegalStateException noNumLeft = new IllegalStateException("operator '"
                    + op + "' at index " + i + " doesn't have enough operands to work with");

            switch (op) {
                case "+": // record the sum of the last two num
                    if(nums.size() < 2) throw noNumLeft;
                    int top = nums.pop();
                    try {
                        int sum = Math.addExact(nums.peek(), top);
                        nums.push(top);
                        nums.push(sum);
                    }
                    catch(ArithmeticException e) {
                        throw new ArithmeticException("exception from " + top
                                + " + " + nums.peek() + " due to integer overflow at index " + i); }
                    break;

                case "D": // record 2 times the last num
                    if(nums.isEmpty()) throw noNumLeft;
                    try {
                        int product = Math.multiplyExact(nums.peek(), 2);
                        nums.push(product);
                    }
                    catch(ArithmeticException e) {
                        throw new ArithmeticException("exception from "
                                + nums.peek() + " * 2 due to an integer overflow at index " + i); }
                    break;

                case "C": // invalidate last num
                    if(nums.isEmpty()) throw noNumLeft;
                    nums.pop();
                    break;

                default: // record any number
                    try {
                        nums.push(Integer.parseInt(op));
                    }
                    catch(NumberFormatException e) {
                        throw new NumberFormatException(
                                "operation '" + op + "' at index " + i + " must be an integer, +, D, or C"); }
            }
        }
        int finalScore = 0;

        while(!nums.empty()) {
            int num = nums.pop();
            try {
                finalScore = Math.addExact(finalScore, num);
            }
            catch(ArithmeticException e) { throw new ArithmeticException("exception from "
                    + num + " + " + finalScore + " due to integer overflow at sum of all scores"); }
        }

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
