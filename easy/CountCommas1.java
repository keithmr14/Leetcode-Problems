package easy;

public class CountCommas1 {

    public static int countCommas(int n) {

        if(n < 1) throw new IllegalArgumentException("n of " + n + " must be greater than 0");

        int commas = 0;
        int digit = 1000;

        while(n >= digit) {
            try {
                commas = Math.addExact(commas, n - digit + 1);
            }
            catch(ArithmeticException e) { throw new ArithmeticException(
                    "number of commas exceeded Integer.MAX_VALUE"); }

            digit *= 1000;
        }

        return commas;
    }

    public static void main(String[] args) {

        System.out.println("3870. Count Commas in Range");

        // example 1
        int n1 = 1002;
        System.out.println("\nRange: [1, " + n1 + "]");
        System.out.println("Commas in Range: " + countCommas(n1));

        // example 2
        int n2 = 2000;
        System.out.println("\nRange: [1, " + n2 + "]");
        System.out.println("Commas in Range: " + countCommas(n2));
    }
}
