package medium;

public class CountCommas2 {

    public static long countCommas(long n) {

        if(n < 1) throw new IllegalArgumentException("n of " + n + " must be greater than 0");

        long commas = 0;
        long digit = 1000;

        while(n >= digit) {
            try {
                commas = Math.addExact(commas, n - digit + 1);
            }
            catch(ArithmeticException e) { throw new ArithmeticException(
                    "number of commas exceeded Long.MAX_VALUE"); }

            digit *= 1000;
        }

        return commas;
    }

    public static void main(String[] args) {

        System.out.println("3871. Count Commas in Range II");

        // example 1
        long n1 = 1002;
        System.out.println("\nRange: [1, " + n1 + "]");
        System.out.println("Commas in Range: " + countCommas(n1));

        // example 2
        long n2 = 2000;
        System.out.println("\nRange: [1, " + n2 + "]");
        System.out.println("Commas in Range: " + countCommas(n2));
    }
}
