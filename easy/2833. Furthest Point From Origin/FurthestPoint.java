public class FurthestPoint {

    public static int furthestDistanceFromOrigin(String moves) {

        int left = 0;
        int right = 0;
        int blank = 0;

        for(int i = 0; i < moves.length(); i++) {

            switch(moves.charAt(i)) {
                case 'L':
                    left++;
                    break;
                case 'R':
                    right++;
                    break;
                case '_':
                    blank++;
                    break;
            }
        }
        // add value of blank to the furthest direction
        return (left >= right) ? left - right + blank : right - left + blank;
    }

    static void main(String[] args) {

        System.out.println("2833. Furthest Point From Origin\n");

        // example 1
        String s1 = "L_RL__R";
        System.out.println(s1);
        System.out.println("Distance: " + furthestDistanceFromOrigin(s1) + "\n");

        // example 2
        String s2 = "_R__LL_";
        System.out.println(s2);
        System.out.println("Distance: " + furthestDistanceFromOrigin(s2) + "\n");
    }
}
