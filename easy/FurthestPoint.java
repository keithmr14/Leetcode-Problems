package easy;

public class FurthestPoint {

    public static int furthestDistanceFromOrigin(String moves) {

        int left = 0;
        int right = 0;
        int blank = 0;

        for(int i = 0; i < moves.length(); i++) {

            char move = moves.charAt(i);

            if(move == 'L') left++;
            else if(move == 'R') right++;
            else if(move == '_') blank++;
            else throw new IllegalArgumentException("character '"
                        + move + "' must be L, R, or _");
        }
        // add value of blank to the furthest direction
        return (left >= right) ? left - right + blank : right - left + blank;
    }

    public static void main(String[] args) {

        System.out.println("2833. Furthest Point From Origin");

        // example 1
        String s1 = "L_RL__R";
        System.out.println("\nString: " + s1);
        System.out.println("Distance: " + furthestDistanceFromOrigin(s1));

        // example 2
        String s2 = "_R__LL_";
        System.out.println("\nString: " + s2);
        System.out.println("Distance: " + furthestDistanceFromOrigin(s2));
    }
}
