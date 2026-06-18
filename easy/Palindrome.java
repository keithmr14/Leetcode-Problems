package easy;

public class Palindrome {

    public static boolean isPalindrome(int x) {

        String num = String.valueOf(x);
        int i = 0;
        int j = num.length() - 1;

        while(i < j) {

            if(num.charAt(i) == num.charAt(j)) { i++; j--; }

            else return false;
        }

        return true;
    }

    public static void main(String[] args) {

        System.out.println("9. Palindrome Number");

        // example 1
        int n1 = 11;
        System.out.println("\nInteger: " + n1);
        System.out.println("Is Palindrome? " + isPalindrome(n1));

        // example 2
        int n2 = -121;
        System.out.println("\nInteger: " + n2);
        System.out.println("Is Palindrome? " + isPalindrome(n2));
    }
}
