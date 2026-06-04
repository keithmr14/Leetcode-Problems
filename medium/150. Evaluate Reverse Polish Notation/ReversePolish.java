import java.util.Arrays;
import java.util.Stack;

public class ReversePolish {

    public static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>(); // String so that we can store operations

        for(String str : tokens) { // for each token

            if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                // if an operator, pop (and remove from stack) the last two operand
                int op2 = Integer.parseInt(stack.pop());
                int op1 = Integer.parseInt(stack.pop());
                // do operation base on current token (operation)
                int res = switch (str) {
                    case "+" -> op1 + op2;
                    case "-" -> op1 - op2;
                    case "*" -> op1 * op2;
                    case "/" -> op1 / op2;
                    default -> 0;
                };
                stack.push(String.valueOf(res)); // push the result in String
            }
            else stack.push(str); // push the operand token if not an operator
        }
        return Integer.parseInt(stack.peek()); // return the last element (result) in int
    }

    static void main(String[] args) {

        System.out.println("150. Evaluate Reverse Polish Notation\n");

        // example 1
        String[] s1 = {"2", "1", "+", "3", "*"};
        System.out.println(Arrays.toString(s1));
        System.out.println("Result: " + evalRPN(s1) + "\n");

        // example 1
        String[] s2 = {"4", "13", "5", "/", "+"};
        System.out.println(Arrays.toString(s2));
        System.out.println("Result: " + evalRPN(s2) + "\n");
    }
}
