public class RotatedDigits {

    public static int rotatedDigits(int n) {

        int ans = 0;

        for(int i = 1; i <= n; i++) { // for each 1 to n

            int num = i;
            boolean valid = false; // assume num is invalid

            while (num >= 1) { // when num's last digit / 10, it will be < 1

                int d = num % 10; // get last digit

                if(d == 2 || d == 5 || d == 6 || d == 9) { // valid and changes
                    valid = true;
                }
                else if(d == 3 || d == 4 || d == 7) { // invalid numbers
                    valid = false;
                    break;
                }

                num /= 10; // remove last digit
            }

            if(valid) ans++;
        }

        return ans;
    }

    static void main(String[] args) {

        System.out.println("788. Rotated Digits\n");

        // example 1
        int n1 = 857;
        System.out.println("Range: [1, " + n1 + "]");
        System.out.println("Good Numbers: " + rotatedDigits(n1) + "\n");

        // example 2
        int n2 = 10;
        System.out.println("Range: [1, " + n2 + "]");
        System.out.println("Good Numbers: " + rotatedDigits(n2) + "\n");
    }
}
