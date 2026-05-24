import java.util.ArrayDeque;
import java.util.Deque;

public class LongestParentheses {

    public static int longestValidParentheses(String s) {

        // Using ArrayDeque as it is faster than the legacy java.util.Stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // -1 pointer where everything in the left is disconnected to the right
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') stack.push(i);

            else {
                stack.pop(); // if it removed a '(' instead of -1 pointer, then the parentheses are valid

                // ')' overnumbered '(' if -1 pointer was popped, make this ')' be the -1 pointer
                if (stack.isEmpty()) stack.push(i);

                // so long that ')' <= '(', starting from -1 pointer, it is a valid parentheses
                // record length starting from -1 pointer to i and compare the biggest so far
                else maxLength = Math.max(maxLength, i - stack.peek());
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println("32. Longest Valid Parentheses");

        // example 1
        String s1 = ")()())";
        System.out.println("\nString: " + s1);
        System.out.println("Longest Valid: " + longestValidParentheses(s1));

        // example 2
        String s2 = "()(())";
        System.out.println("\nString: " + s2);
        System.out.println("Longest Valid: " + longestValidParentheses(s2));
    }

}
