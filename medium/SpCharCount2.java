package medium;

public class SpCharCount2 {

    public static int numberOfSpecialChars(String word) {

        // Record of letters, whether they're not seen yet (0),
        // last seen as lowercase (1),
        // last seen as uppercase (2),
        // or the letter is already ineligible to be special (-1).
        int[] states = new int[26];

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if('a' <= c && c <= 'z') {

                int lastSeenAs = states[c - 'a'];

                if(lastSeenAs == 2) states[c - 'a'] = -1;

                else if(lastSeenAs == 0) states[c - 'a'] = 1;
            }
            else if ('A' <= c && c <= 'Z'){

                int lastSeenAs = states[c - 'A'];

                if(lastSeenAs == 0) states[c - 'A'] = -1;

                else if(lastSeenAs == 1) states[c - 'A'] = 2;
            }
            else throw new IllegalArgumentException("character '" + c + "' is not an English letter");
        }

        int specials = 0;

        for(int i = 0; i < 26; i++) { if(states[i] == 2) specials++; }

        return specials;
    }

    public static void main(String[] args) {

        System.out.println("3121. Count the Number of Special Characters II");

        // example 1
        String s1 = "AbcbDBdD";
        System.out.println("\nString: " + s1);
        System.out.println("Special Count: " + numberOfSpecialChars(s1));

        // example 2
        String s2 = "cCceDC";
        System.out.println("\nString: " + s2);
        System.out.println("Special Count: " + numberOfSpecialChars(s2));
    }
}
