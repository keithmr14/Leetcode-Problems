package medium;

public class ClockAngle {

    public static double angleClock(int hour, int minutes) {

        if(hour < 1 || hour > 12) throw new IllegalArgumentException("hours must be between 1 and 12");
        if(minutes < 0 || minutes > 59) throw new IllegalArgumentException("minutes must be between 0 and 59");

        if(hour == 12) hour = 0;

        double minuteAngle = minutes * 6;
        double hourAngle = (hour * 30) + ((minuteAngle / 360) * 30);

        double diff1 = Math.abs(minuteAngle - hourAngle);
        double diff2 = 360 - diff1;

        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {

        System.out.println("1344. Angle Between Hands of a Clock");

        // example 1
        int h1 = 12;
        int m1 = 30;
        System.out.println("\nTime: " + h1 + ":" + m1);
        System.out.println("Minimum Angle: " + angleClock(h1, m1));

        // example 2
        int h2 = 3;
        int m2 = 15;
        System.out.println("\nTime: " + h2 + ":" + m2);
        System.out.println("Minimum Angle: " + angleClock(h2, m2));
    }
}
