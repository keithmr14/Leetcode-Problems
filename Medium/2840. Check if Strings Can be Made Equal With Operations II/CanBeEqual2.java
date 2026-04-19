public class CanBeEqual2 {

    public static boolean checkStrings(String s1, String s2) {

        int n = s1.length();

        // frequency counter of each letter in even indexes
        int[] evenCounts = new int[26];

        for (int i = 0; i < n; i += 2) {
            // add count using ASCII index
            evenCounts[s1.charAt(i) - 'a']++; // +1 to letter count
            evenCounts[s2.charAt(i) - 'a']--; // -1 to letter count
        }

        for (int count : evenCounts) {
            /* for it to be equal, characters in even indexes
            from both strings must cancel each other out */
            if (count != 0) return false;
        }

        // frequency counter of each letter in odd indexes
        int[] oddCounts = new int[26];

        for (int i = 1; i < n; i += 2) {
            oddCounts[s1.charAt(i) - 'a']++; // +1 to letter count
            oddCounts[s2.charAt(i) - 'a']--; // -1 to letter count
        }
        for (int count : oddCounts) {
            /* for it to be equal, characters in odd indexes
            from both strings must cancel each other out */
            if (count != 0) return false;
        }

        // if both counter is empty
        return true;
    }

    static void main(String[] args) {

        System.out.println("2840. Check if Strings Can be Made Equal With Operations II\n");

        // example 1
        String a1 = "abcdba";
        String b1 = "cabdab";
        System.out.println(a1 + " & " + b1);
        String out1 = (checkStrings(a1, b1)) ? "CAN be made equal\n" : "CANNOT be made equal\n";
        System.out.println(out1);

        // example 1
        String a2 = "abe";
        String b2 = "bea";
        System.out.println(a2 + " & " + b2);
        String out2 = (checkStrings(a2, b2)) ? "CAN be made equal\n" : "CANNOT be made equal\n";
        System.out.println(out2);
    }
}
