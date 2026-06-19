package easy;

import java.util.Arrays;

public class WeightedWord {

    public static String mapWordWeights(String[] words, int[] weights) {

        if(weights.length != 26) throw new IllegalArgumentException("weights length should be 26, not " + weights.length);
        if(words.length == 0) throw new IllegalArgumentException("words array is empty");

        StringBuilder mappedWord = new StringBuilder();

        for(String word : words) {

            int wordWeight = getWordWeight(weights, word);
            int revASCII = 'z' - wordWeight;
            mappedWord.append((char) revASCII);
        }

        return mappedWord.toString();
    }

    private static int getWordWeight(int[] weights, String word) {

        int wordWeight = 0;

        for(int i = 0; i < word.length(); i++) {

            char letter = word.charAt(i);

            if(letter < 'a' || letter > 'z')
                throw new IllegalArgumentException("character '" + letter + "' was found in word \"" + word + "\"");

            try {
                wordWeight = Math.addExact(weights[letter - 'a'], wordWeight);
            }
            catch(ArithmeticException e) {
                throw new IllegalArgumentException("weight of word \"" + word + "\" causes an integer overflow"); }
        }

        if(wordWeight < 0) throw new IllegalArgumentException("weight of word \"" + word + "\" is negative " + wordWeight);

        wordWeight %= 26;

        return wordWeight;
    }

    public static void main(String[] args) {

        System.out.println("3838. Weighted Word Mapping");

        // example 1
        String[] words1 = {"a", "b", "c"};
        int[] weights1 = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println("\nWords: " + Arrays.toString(words1));
        System.out.println("Weights: " + Arrays.toString(weights1));
        System.out.println("Mapped Word: " + mapWordWeights(words1, weights1));

        // example 2
        String[] words2 = {"abcd", "def", "xyz"};
        int[] weights2 = {5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2};
        System.out.println("\nWords: " + Arrays.toString(words2));
        System.out.println("Weights: " + Arrays.toString(weights2));
        System.out.println("Mapped Word: " + mapWordWeights(words2, weights2));
    }
}
