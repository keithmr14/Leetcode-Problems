package easy;

public class SpCharCount1 {

    public static int numberOfSpecialChars(String word) {

        // 'seen' table for uppercase/lowercase letters
        boolean[] uppercase = new boolean[26];
        boolean[] lowercase = new boolean[26];

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if('a' <= c && c <= 'z') lowercase[c - 'a'] = true;

            else if('A' <= c && c <= 'Z') uppercase[c - 'A'] = true;

            else throw new IllegalArgumentException("character c must be an english letter");
        }

        int count = 0;

        for(int i = 0; i < 26; i++) {

            if(uppercase[i] && lowercase[i]) count++;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println("3120. Count the Number of Special Characters I");

        // example 1
        String s1 = "aaAbcBC";
        System.out.println("\nLetters: " + s1);
        System.out.println("Special Count: " + numberOfSpecialChars(s1));

        // example 2
        String s2 = "abBCab";
        System.out.println("\nLetters: " + s2);
        System.out.println("Special Count: " + numberOfSpecialChars(s2));
    }
}
