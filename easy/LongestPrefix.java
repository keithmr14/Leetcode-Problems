package easy;

import java.util.Arrays;

public class LongestPrefix {

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];

        String str1 = strs[0];

        for(int i = 0; i < str1.length(); i++) {

            char c = str1.charAt(i);

            for(int j = 1; j < strs.length; j++) {

                if(i >= strs[j].length() || strs[j].charAt(i) != c) {

                    return str1.substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {

        System.out.println("14. Longest Common Prefix");

        // example 1
        String[] a1 = {"flower", "flow", "flight"};
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(a1));

        // example 2
        String[] a2 = {"dog", "racecar", "car"};
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(a2));
    }
}
