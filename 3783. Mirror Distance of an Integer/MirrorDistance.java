public class MirrorDistance {

    public static int mirrorDistance(int n) {

        String reversedStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        int reversedNum = Integer.parseInt(reversedStr);

        System.out.println("||" + n + " - " + reversedNum + "||");
        return Math.abs(n - reversedNum);
    }

    public static void main(String[] args) {

        System.out.println("3783. Mirror Distance of an Integer\n");

        // example 1
        System.out.println("Mirror Distance: " + mirrorDistance(25) + "\n");

        // example 2
        System.out.println("Mirror Distance: " + mirrorDistance(10) + "\n");
    }
}
