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

                int res = switch(str) {
                    case "+" -> op1 + op2;
                    case "-" -> op1 - op2;
                    case "*" -> op1 * op2;
                    case "/" -> op1 / op2;
                    default -> 0;
                };
                stack.push(String.valueOf(res));
            }
            else {
                try {
                    Integer.parseInt(str);
                    stack.push(str);

                } catch(NumberFormatException e) {
                    throw new IllegalArgumentException("token must only be an integer, +, -, *, or /");
                }
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
