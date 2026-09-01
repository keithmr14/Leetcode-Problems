package easy;

import java.util.Stack;

public class Parentheses {

    public static boolean isValid(String s) {

        Stack<Character> openPts = new Stack<>();

        for(int i = 0; i < s.length(); i++) {

            char pts = s.charAt(i);

            if(pts == '(' || pts == '{' || pts == '[') {

                openPts.push(pts);
                continue;
            }

            char peek = (openPts.empty()) ? '0' : openPts.peek();

            switch(pts) {

                case ')':
                    if(peek == '(') openPts.pop();
                    else return false;
                    break;
                case '}':
                    if(peek == '{') openPts.pop();
                    else return false;
                    break;
                case ']':
                    if(peek == '[') openPts.pop();
                    else return false;
                    break;
                default:
                    throw new IllegalArgumentException("character '" + pts + "' must be a parenthesis");
            }
        }
        // return true if no parenthesis unmatched left, else false
        return(openPts.empty());
    }

    public static void main(String[] args) {

        System.out.println("20. Valid Parentheses");

        // example 1
        String s1 = "()[]{}(";
        System.out.println("\nString: \"" + s1 + "\"");
        System.out.println("Valid Parentheses? " + isValid(s1));

        // example 2
        String s2 = "([])";
        System.out.println("\nString: \"" + s2 + "\"");
        System.out.println("Valid Parentheses? " + isValid(s2));
    }
}