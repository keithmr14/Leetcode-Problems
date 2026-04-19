import java.util.Arrays;

public class LongestPrefix {

    public static String longestCommonPrefix(String[] strs) {

        String str1 = strs[0]; // first string will be the basis

        // for each character in string 1
        for(int s1Char = 0; s1Char < str1.length(); s1Char++) {

            char c = str1.charAt(s1Char);

            // for each string tested
            for(int elem = 0; elem < strs.length; elem++) {

                // once it differ or ran out of characters
                if(s1Char >= strs[elem].length() || strs[elem].charAt(s1Char) != c) {
                    // return only the characters that finished a round
                    // .charAt(s1Char) is not included in .substring
                    return str1.substring(0, s1Char);
                }
            }
        }
        // if all element are identical
        return strs[0];
    }

    public static void main(String[] args) {

        System.out.println("14. Longest Common Prefix\n");

        // example 1
        String[] a1 = {"flower", "flow", "flight"};
        System.out.println(Arrays.toString(a1));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(a1) + "\n");

        // example 1
        String[] a2 = {"dog", "racecar", "car"};
        System.out.println(Arrays.toString(a2));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(a2) + "\n");
    }
}
