public class SpCharCount2 {

    public static int numberOfSpecialChars(String word) {

        // Record of letters whether they're not seen yet (0),
        // last seen as lowercase (1),
        // last seen as uppercase (2),
        // or letter is already ineligible to be special (-1).
        int[] states = new int[26];

        for(int i = 0; i < word.length(); i++) {

            char c = word.charAt(i);

            if('a' <= c) { // 'a' <= c <= 'z', given that only letters exist

                // if uppercase already appeared, mark state as invalid
                if(states[c - 'a'] == 2) states[c - 'a'] = -1;

                // only mark state as lowercase if state is 0
                else if(states[c - 'a'] == 0) states[c - 'a'] = 1;
            }

            else { // 'A' <= c <= 'Z', given that only letters exist

                // if state is empty, mark state as invalid
                if(states[c - 'A'] == 0) states[c - 'A'] = -1;

                // only mark state as uppercase if state is 1
                else if(states[c - 'A'] == 1) states[c - 'A'] = 2;
            }
        }

        int count = 0; // number of 'special' characters

        for(int i = 0; i < 26; i++) {

            // count how many letters ended in uppercase
            if(states[i] == 2) count++;
        }

        return count;
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
