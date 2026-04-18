import java.util.Arrays;
import java.util.Objects;

public class ClosestTarget {

    public int closestTarget(String[] words, String target, int startIndex) {

        System.out.println("ARR: " + Arrays.toString(words));
        System.out.println("Target: " + target + "\nStarting Index: " + startIndex);

        int end = words.length - 1; // last index
        int i = startIndex; // pointer
        int minDist = words.length; // instead of null, set out of range higher

        // move out of startIndex where distance is 0 and for while loop to have a target
        if(Objects.equals(words[startIndex], target)) return 0;
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
            i = (i == end) ? 0 : i + 1; // m
        }
        // if distance is left untouched return -1
        int result = (minDist != words.length) ? minDist : -1;

        System.out.println("Closest Target Distance: " + result + "\n");

        return result;
    }

    public static void main(String[] args) {

        System.out.println("2515. Shortest Distance to Target String in a Circular Array\n");

        ClosestTarget ct = new ClosestTarget();

        // example 1
        String[] array = {"hello", "i", "am", "leetcode", "hello"};
        ct.closestTarget(array, "hello", 1);

        // example 2
        String[] array2 = {"i", "eat", "leetcode"};
        ct.closestTarget(array2, "ate", 0);
    }
}
