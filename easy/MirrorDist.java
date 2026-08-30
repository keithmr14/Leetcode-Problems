package easy;

public class MirrorDist {

    public static int mirrorDistance(int num) {

        if(num < 0) throw new IllegalArgumentException("integer "
                + num + " mustn't be less than 0");

        String numS = String.valueOf(num);
        numS = new StringBuilder(numS).reverse().toString();
        int rev = Integer.parseInt(numS);

        return Math.abs(num - rev);
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
