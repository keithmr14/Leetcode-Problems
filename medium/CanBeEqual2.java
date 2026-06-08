package medium;

public class CanBeEqual2 {

    public static boolean checkStrings(String s1, String s2) {

        int n = s1.length();
        int[] even = new int[26];
        int[] odd = new int[26];
        
        for(int i = 0; i < n; i += 2) {
            even[s1.charAt(i) - 'a']++;
            even[s2.charAt(i) - 'a']--;
        }
        
        for(int count : even) if(count != 0) return false;
        
        for(int i = 1; i < n; i += 2) {
            odd[s1.charAt(i) - 'a']++;
            odd[s2.charAt(i) - 'a']--;
        }
        
        for (int count : odd) if(count != 0) return false;
        
        // if both counter is empty (letters from both string cancel each other)
        return true;
    }

    public static void main(String[] args) {

        System.out.println("2840. Check if Strings Can be Made Equal With Operations II");
        
        // example 1
        String a1 = "abcdba";
        String a2 = "cabdab";
        System.out.println("\nNum 1: " + a1 + "\nNum 2: " + a2);
        System.out.println("Can be made equal ? " + checkStrings(a1, a2));
        
        // example 2
        String b1 = "abe";
        String b2 = "bea";
        System.out.println("\nNum 1: " + b1 + "\nNum 2: " + b2);
        System.out.println("Can be made equal ? " + checkStrings(b1, b2));
    }
}
