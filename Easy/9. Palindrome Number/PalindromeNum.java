public class PalindromeNum {

    public static boolean isPalindrome(int x) {
        // turn the number to String so we can use .charAt
        String num = String.valueOf(x);
        int i = 0; // first char pointer
        int j = num.length() - 1; // last char pointer
        // if pointing at the same character or moved past each other,
        // there's no need for comparison
        while(i < j) {
            // if both ends are symmetric move pointer closer together
            if(num.charAt(i) == num.charAt(j)) {
                i++;
                j--;
            }
            else return false;
        }
        return true;
    }

    static void main(String[] args) {

        System.out.println("9. Palindrome Number\n");

        // example 1
        int n1 = 11;
        System.out.println(n1);
        System.out.println("Is Palindrome? " + isPalindrome(n1) + "\n");

        // example 2
        int n2 = -121;
        System.out.println(n2);
        System.out.println("Is Palindrome? " + isPalindrome(n2) + "\n");
    }
}
