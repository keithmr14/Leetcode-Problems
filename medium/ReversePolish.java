package medium;

import java.util.Arrays;
import java.util.Stack;

public class ReversePolish {

    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        for(String str : tokens) {

            if(str == null) throw new IllegalArgumentException("a token is empty");

            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {

                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());

                try {
                    int res = switch(str) {
                        case "+" -> Math.addExact(op1, op2);
                        case "-" -> Math.subtractExact(op1, op2);
                        case "*" -> Math.multiplyExact(op1, op2);
                        case "/" -> Math.divideExact(op1, op2);
                        default -> 0;
                    };
                    stack.push(String.valueOf(res));
                }
                catch(ArithmeticException e) {
                    throw new IllegalArgumentException(op1 + " " + str + " " + op2 + " causes an exception: " + e.getMessage()); }
            }
            else {
                try {
                    Integer.parseInt(str);
                }
                catch(NumberFormatException e) {
                    throw new IllegalArgumentException("token '" + str + "' must be an integer, +, -, *, or /"); }

                stack.push(str);
            }

        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {

        System.out.println("150. Evaluate Reverse Polish Notation");

        // example 1
        String[] s1 = {"2", "1", "+", "3", "*"};
        System.out.println("\nTokens: " + Arrays.toString(s1));
        System.out.println("Result: " + evalRPN(s1));

        // example 2
        String[] s2 = {"4", "13", "5", "/", "+"};
        System.out.println("\nTokens: " + Arrays.toString(s2));
        System.out.println("Result: " + evalRPN(s2));
    }
}
