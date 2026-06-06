public class RotateString {

    public static boolean rotateString(String s, String goal) {

        // if unequal length anyway
        if(s.length() != goal.length()) return false;
        // if equal anyway
        if(s.equals(goal)) return true;
        // used to rotate s string
        StringBuilder str = new StringBuilder(s);

        // once i = s.length, it reaches original point
        for(int i = 0; i < s.length(); i++) {
            // rotate s string
            str.append(str.charAt(0));
            str.deleteCharAt(0);
            // compare it again
            if(goal.contentEquals(str)) return true;
        }
        // when it fully rotates but still didn't equal
        return false;
    }

    public static void main(String[] args) {

        System.out.println("796. Rotate String\n");

        // example 1
        String s1 = "abcde";
        String g1 = "cdeab";
        System.out.println(s1 + " & " + g1);
        System.out.println("Rotatable? " + rotateString(s1, g1) + "\n");

        // example 2
        String s2 = "abcde";
        String g2 = "abced";
        System.out.println(s2 + " & " + g2);
        System.out.println("Rotatable? " + rotateString(s2, g2) + "\n");
    }
}
