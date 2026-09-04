package easy;

public class RotateString {

    public static boolean rotateString(String s, String goal) {

        if(s.equals(goal)) return true;

        StringBuilder str = new StringBuilder(s);

        for(int i = 0; i < s.length(); i++) {

            str.append(str.charAt(0));
            str.deleteCharAt(0);

            if(goal.contentEquals(str)) return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println("796. Rotate String");

        // example 1
        String s1 = "abcde";
        String s2 = "cdeab";
        System.out.println("\nString 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Rotatable? " + rotateString(s1, s2));

        // example 2
        s1 = "abcde";
        s2 = "abced";
        System.out.println("\nString 1: " + s1);
        System.out.println("String 2: " + s2);
        System.out.println("Rotatable? " + rotateString(s1, s2));
    }
}
