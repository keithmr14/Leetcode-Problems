package easy;

public class CanBeEqual1 {

    public static boolean canBeEqual(String s1, String s2) {

        if(s1.length() != 4 || s2.length() != 4) throw new IllegalArgumentException(
                "both strings must have a length of 4");

        // Check if even indices (0, 2) can be made equal
        boolean even = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
                (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // Check if odd indices (1, 3) can be made equal
        boolean odd = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
                (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return even && odd;
    }

    public static void main(String[] args) {

        System.out.println("2839. Check if Strings Can be Made Equal With Operations I");

        // example 1
        String a1 = "jjgg";
        String a2 = "gjgj";
        System.out.println("\nNum 1: " + a1);
        System.out.println("Num 2: " + a2);
        System.out.println("Can be made equal? " + canBeEqual(a1, a2));

        // example 2
        String b1 = "abcd";
        String b2 = "cdab";
        System.out.println("\nNum 1: " + b1);
        System.out.println("Num 2: " + b2);
        System.out.println("Can be made equal? " + canBeEqual(b1, b2));
    }
}
