import java.util.*;

public class MaxUniqueDistance {

    public static int maxDistance(int[] colors) {

        int maxDist = 0; // maximum distance
        int distance; // current longest distance

        // first appearance of each color will make for the left-most unique color
        // <Color, Index>
        HashMap<Integer, Integer> count = new HashMap<>();

        // keep track of the first color first so we can calculate distance immediately
        count.put(colors[0], 0);

        for(int i = 1; i < colors.length; i++) {
            int color = colors[i];

            if(!count.containsKey(color)) {
                /* if hash map doesn't have the current color yet, calculate the distance
                   between index and smallest index in the hash map/left-most unique color */

                distance = i - Collections.min(count.values());
                maxDist = Math.max(distance, maxDist);
                count.put(color, i); // keep the track of the new color

            } else {
                /* if hash map already have the current color, calculate the distance between index
                   and smallest index in the hash map that is not of that color/left-most unique color */

                distance = i - count.entrySet() // let you iterate through the hash map
                        .stream() // let you use the Stream methods below:
                        .filter(entry -> !entry.getKey().equals(color)) // skip its own color
                        .mapToInt(Map.Entry::getValue) // get only the values
                        .min() // find the minimum
                        .orElse(-1);

                maxDist = Math.max(distance, maxDist);
            }
        }
        return maxDist;
    }

    static void main(String[] args) {

        System.out.println("2078. Two Furthest Houses with Different Colors\n");

        // example 1
        int[] a1 = {1, 1, 1, 6, 1, 1, 1};
        System.out.println("Houses: " + Arrays.toString(a1));
        System.out.println("Max Distance: " + maxDistance(a1) + "\n");

        // example 2
        int[] a2 = {1, 8, 3, 8, 3};
        System.out.println("Houses: " + Arrays.toString(a2));
        System.out.println("Max Distance: " + maxDistance(a2) + "\n");
    }
}
