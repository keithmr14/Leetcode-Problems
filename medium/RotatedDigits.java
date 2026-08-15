package medium;

public class RotatedDigits {

    private static int[] memo = new int[11];
    private static int maxN = 0;

    public static int rotatedDigits(int n) {

        if(n < 1 || n == Integer.MAX_VALUE)
            throw new IllegalArgumentException("n of " + n + " must be between 1 and Integer.MAX_VALUE - 1");

        if(n >= memo.length) {

            int newSize = n + 1;
            int[] newMemo = new int[newSize];
            System.arraycopy(memo, 0, newMemo, 0, memo.length);
            memo = newMemo;
        }

        if(n > maxN) {
            int good = memo[maxN]; // 1-indexed

            for(int currNum = maxN + 1; currNum <= n; currNum++) {

                if(isGoodNumber(currNum)) good++;

                memo[currNum] = good;
            }
            maxN = n;
        }

        return memo[n];
    }

    private static boolean isGoodNumber(int num) {

        boolean valid = false;

        while(num >= 1) {
            int lastDig = num % 10;

            if(lastDig == 2 || lastDig == 5 || lastDig == 6 || lastDig == 9) valid = true;

            else if(lastDig == 3 || lastDig == 4 || lastDig == 7) return false;
            // 1 and 0 are valid but doesn't change so we need to check for more digit
            num /= 10;
        }
        return valid;
    }

    public static void main(String[] args) {

        System.out.println("788. Rotated Digits");

        // example 1
        int n1 = 857;
        System.out.println("\nRange: [1, " + n1 + "]");
        System.out.println("Good Numbers: " + rotatedDigits(n1));

        // example 2
        int n2 = 10;
        System.out.println("\nRange: [1, " + n2 + "]");
        System.out.println("Good Numbers: " + rotatedDigits(n2));
    }
}
