public class SpCharCount1 {

    public static int numberOfSpecialChars(String word) {

        // 'seen' table for uppercase/lowercase letters
        boolean[] uppercase = new boolean[26];
        boolean[] lowercase = new boolean[26];

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            // given that only letters exist, uppercase have lower ASCII
            if('a' <= c) lowercase[c - 'a'] = true;
            // get ASCII (relative to first letter) and mark it as seen
            else uppercase[c - 'A'] = true;
        }

        int count = 0; // number of 'special letters'

        for(int i = 0; i < 26; i++) { // count how many pairs are made

            if(uppercase[i] && lowercase[i]) count++; // (true & true)
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
