public class MirrorDistance {

    public int mirrorDistance(int n) {

        String reversedStr = new StringBuilder(String.valueOf(n)).reverse().toString();
        int reversedNum = Integer.parseInt(reversedStr);

        int result = Math.abs(n - reversedNum);

        System.out.println("||" + n + " - " + reversedNum + "||");
        System.out.println("Mirror Distance: " + result + "\n");

        return result;
    }

    public static void main(String[] args) {

        System.out.println("3783. Mirror Distance of an Integer\n");

        MirrorDistance md = new MirrorDistance();

        md.mirrorDistance(25); // example 1

        md.mirrorDistance(10); // example 2
    }
}
