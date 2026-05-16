public class LengthLastWord {

    public static int lengthOfLastWord(String s) {

        int wordLength = 0;

        // start checking for word at the end of string
        for(int i = s.length() - 1; i >= 0; i--) {

            if(s.charAt(i) == ' ') {
                // if a word has already formed
                if(wordLength > 0) return wordLength;
            }
            else wordLength++; // detecting a letter
        }

        return wordLength; // if no space detected
    }

    public static void main(String[] args) {

        System.out.println("58. Length of Last Word");

        // example 1
        String s1 = "Hello World";
        System.out.println("\n\"" + s1 + "\"\nLength: " + lengthOfLastWord(s1));

        // example 2
        String s2 = "   fly me   to   the moon  ";
        System.out.println("\n\"" + s2 + "\"\nLength: " + lengthOfLastWord(s2));
    }
}
