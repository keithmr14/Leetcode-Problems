package easy;

import java.util.Arrays;

public class ClosestTarget {

    public static int closestTarget(String[] words, String target, int startIndex) {

        int end = words.length - 1;
        int i = startIndex;
        int minDist = words.length;

        if(startIndex < 0 || startIndex + 1 > minDist) throw new IllegalArgumentException("start index "
                + i + " must be greater than or equal to 0 and less than words array length " + minDist);
        if(target.equals(words[startIndex])) return 0;

        i = (startIndex == end) ? 0 : i + 1;

        while(i != startIndex) {

            if(target.equals(words[i])) {

                int right = (i >= startIndex) ? i - startIndex : i + 1 + end - startIndex;
                int left = (i <= startIndex) ? startIndex - i : startIndex + end - i + 1;
                int min = Math.min(right, left);

                if (min < minDist) minDist = min;
            }

            i = (i == end) ? 0 : i + 1;
        }

        return (minDist != words.length) ? minDist : -1;
    }

    public static void main(String[] args) {

        System.out.println("2515. Shortest Distance to Target String in a Circular Array");

        // example 1
        String[] a1 = {"hello", "i", "am", "leetcode", "hello"};
        String t1 = "hello";
        int s1 = 1;
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Target: " + t1);
        System.out.println("Starting Index: " + s1);
        int out1 = closestTarget(a1, t1, s1);
        System.out.println("Closest Target Distance: " + out1);

        // example 2
        String[] a2 = {"i", "eat", "leetcode"};
        String t2 = "ate";
        int s2 = 0;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Target: " + t2);
        System.out.println("Starting Index: " + s2);
        int out2 = closestTarget(a1, t2, s2);
        System.out.println("Closest Target Distance: " + out2);
    }
}
