package easy;

import java.util.Arrays;

public class WeightedWord {

    public static String mapWordWeights(String[] words, int[] weights) {

        if(weights.length != 26) throw new IllegalArgumentException("weights array length must be 26");
        if(words.length == 0) throw new IllegalArgumentException("words array mustn't be empty");

        StringBuilder mappedWord = new StringBuilder();

        for(int i = 0; i < 26; i++) {

            int weight = weights[i];

            if(weight < 1) throw new IllegalArgumentException("weight " + weight + " at index "
                    + i + " must be greater than or equal to 1");
        }

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

            char c = word.charAt(i);

            if(c < 'a' || c > 'z')
                throw new IllegalArgumentException("character '" + c
                        + "' at word \"" + word + "\" must be a lowercase english letter");

            int weight = weights[c - 'a'];

            try {
                wordWeight = Math.addExact(wordWeight, weight);
            }
            catch(ArithmeticException e) {
                throw new ArithmeticException("exception from weight sum " + wordWeight
                        + " + " + weight + " due to integer overflow at word \"" + word + "\""); }
        }

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
