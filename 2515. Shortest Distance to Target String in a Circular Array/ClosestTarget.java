import java.util.Arrays;
import java.util.Objects;

public class ClosestTarget {

    public static int closestTarget(String[] words, String target, int startIndex) {

        int end = words.length - 1; // last index
        int i = startIndex; // pointer
        int minDist = words.length; // instead of null, set out of range higher

        // move out of startIndex where distance is 0 and for while loop to have a target
        if(Objects.equals(words[startIndex], target)) {
            return 0;
        }

        // simulate moving pointer in a circle
        i = (startIndex == end) ? 0 : i + 1;

        while(i != startIndex) { // continues until the array have been traversed

            if(Objects.equals(words[i], target)) {

                // simulate traveling to the right in a circle
                int right = (i >= startIndex) ? i - startIndex : i + 1 + end - startIndex;

                // simulate traveling to the left in a circle
                int left = (i <= startIndex) ? startIndex - i : startIndex + end - i + 1;

                int min = Math.min(right, left); // pick the smallest distance

                if (min < minDist) minDist = min; // compare distance to other equal value
            }
            // simulate moving pointer in a circle
            i = (i == end) ? 0 : i + 1;
        }
        // if distance is left untouched return -1
        return (minDist != words.length) ? minDist : -1;
    }

    public static void main(String[] args) {

        System.out.println("2515. Shortest Distance to Target String in a Circular Array\n");

        // example 1
        String[] array = {"hello", "i", "am", "leetcode", "hello"};
        String target = "hello";
        System.out.println("ARR: " + Arrays.toString(array));
        System.out.println("Target: " + target + "\nStarting Index: " + 1);
        int output = closestTarget(array, target, 1);
        System.out.println("Closest Target Distance: " + output + "\n");

        // example 2
        String[] array2 = {"i", "eat", "leetcode"};
        String target2 = "ate";
        System.out.println("ARR: " + Arrays.toString(array2));
        System.out.println("Target: " + target2 + "\nStarting Index: " + 0);
        int output2 = closestTarget(array, target2, 0);
        System.out.println("Closest Target Distance: " + output2 + "\n");
    }
}
