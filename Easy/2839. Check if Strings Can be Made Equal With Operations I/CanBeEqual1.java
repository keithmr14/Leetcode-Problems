public class CanBeEqual1 {

    public static boolean canBeEqual(String s1, String s2) {

        // Check if even indices (0, 2) can be made equal
        boolean even = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // Check if odd indices (1, 3) can be made equal
        boolean odd = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return even && odd;
    }

    static void main(String[] args) {

        System.out.println("2839. Check if Strings Can be Made Equal With Operations I\n");

        // example 1
        String a1 = "abcd";
        String b1 = "cdab";
        System.out.println(a1 + " & " + b1);
        String out1 = (canBeEqual(a1, b1)) ? "CAN be made equal\n" : "CANNOT be made equal\n";
        System.out.println(out1);

        // example 1
        String a2 = "abcd";
        String b2 = "dacb";
        System.out.println(a2 + " & " + b2);
        String out2 = (canBeEqual(a2, b2)) ? "CAN be made equal\n" : "CANNOT be made equal\n";
        System.out.println(out2);
    }
}
