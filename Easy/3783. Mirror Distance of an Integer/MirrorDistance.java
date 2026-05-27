public class MirrorDist {

    public static int mirrorDistance(int n) {

        int num = n;
        // last digit * 10^pow will be the last digit in the first digit place
        int pow = String.valueOf(n).length() - 1;

        while(num != 0) {

            int lastDigit = num % 10;
            int tenthPlace = (int) Math.pow(10, pow);
            // subtract the last digit in the first digit place to n
            n -= lastDigit * tenthPlace;
            num /= 10; // this will change the last digit we're accessing
            pow--; // reduce the tenth place
        }

        return Math.abs(n); // return the absolute distance
    }

    public static void main(String[] args) {

        System.out.println("3783. Mirror Distance of an Integer");

        // example 1
        int n1 = 25;
        System.out.println("\nInteger: " + n1);
        System.out.println("Mirror Distance: " + mirrorDistance(n1));

        // example 2
        int n2 = 10;
        System.out.println("\nInteger: " + n2);
        System.out.println("Mirror Distance: " + mirrorDistance(n2));
    }
}
