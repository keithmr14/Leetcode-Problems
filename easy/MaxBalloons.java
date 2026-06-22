package easy;

public class MaxBalloons {

    public static int maxNumberOfBalloons(String text) {

        int[] balloonChar = new int[6];
        int max = Integer.MAX_VALUE;

        for(int i = 0; i < text.length(); i++) {

            char c = text.charAt(i);
            int balloonIndex = switch(c) {
                case 'b' -> 1;
                case 'a' -> 2;
                case 'l' -> 3;
                case 'o' -> 4;
                case 'n' -> 5;
                default -> 0;
            };
            balloonChar[balloonIndex]++;
        }

        balloonChar[3] /= 2;
        balloonChar[4] /= 2;

        for(int i = 1; i < 6; i++) {
            max = Math.min(max, balloonChar[i]); }

        return max;
    }

    public static void main(String[] args) {

        System.out.println("1189. Maximum Number of Balloons");

        // example 1
        String s1 = "nlaebolko";
        System.out.println("\nText: " + s1);
        System.out.println("Number of \"balloon\": " + maxNumberOfBalloons(s1));

        // example 2
        String s2 = "loonbalxballpoon";
        System.out.println("\nText: " + s2);
        System.out.println("Number of \"balloon\": " + maxNumberOfBalloons(s2));
    }
}
