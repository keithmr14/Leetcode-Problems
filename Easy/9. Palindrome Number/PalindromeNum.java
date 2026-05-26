public class PalindromeNum {

    public static boolean isPalindrome(int x) {

        // turn the number to String so we can use .charAt
        String num = String.valueOf(x);

        int i = 0; // first char pointer
        int j = num.length() - 1; // last char pointer

        while(i < j) { // while not pointing at the same char or moved past each other

            // if both ends have equal value, move pointer closer to each other
            if(num.charAt(i) == num.charAt(j)) { i++; j--; }
            else return false;
        }

        return true; // if no mismatched number, return true
    }

    public static void main(String[] args) {

        System.out.println("9. Palindrome Number");

        // example 1
        int n1 = 11;
        System.out.println("\nNumber: " + n1);
        System.out.println("Is Palindrome? " + isPalindrome(n1));

        // example 2
        int n2 = -121;
        System.out.println("\nNumber: " + n2);
        System.out.println("Is Palindrome? " + isPalindrome(n2));
    }
}
