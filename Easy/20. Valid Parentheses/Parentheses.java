import java.util.Stack;

public class Parentheses {

    public static boolean isValid(String s) {

        // stack for all parentheses without pair
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) { // for each char/parenthesis

            char pts = s.charAt(i);

            if(stack.empty()) {
                // a closing parenthesis next to empty is invalid
                if(pts == ')' || pts == '}' || pts == ']') return false;
                // opening parenthesis next to empty is fine
                stack.push(pts);
                continue;
            }

            switch(pts) {
                case ')':
                    if(stack.peek() == '(') stack.pop();
                    // a closing parenthesis next to mismatch open is invalid
                    else return false;
                    break;
                case '}':
                    if(stack.peek() == '{') stack.pop();
                    else return false;
                    break;
                case ']':
                    if(stack.peek() == '[') stack.pop();
                    else return false;
                    break;
                default:
                    // this and the last being open parentheses is fine
                    stack.push(pts);
            }
        }
        // return true if no parentheses unmatched left, else false
        return (stack.empty());
    }

    public static void main(String[] args) {

        System.out.println("20. Valid Parentheses");

        // example 1
        String s1 = "()[]{}";
        System.out.println("\nString: " + s1);
        System.out.println("Valid Parentheses? " + isValid(s1));

        // example 2
        String s2 = "(]";
        System.out.println("\nString: " + s2);
        System.out.println("Valid Parentheses? " + isValid(s2));
    }
}
