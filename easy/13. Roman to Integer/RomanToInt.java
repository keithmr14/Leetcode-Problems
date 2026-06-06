public class RomanToInt {

    public static int romanToInt(String s) {

        int ans = 0;
        // special case where lesser symbol appears first
        boolean subI = false;
        boolean subX = false;
        boolean subC = false;

        for(int i = 0; i < s.length(); i++) {

            switch(s.charAt(i)) {
                // add value per symbol
                case 'M':
                    ans += (subC) ? 800 : 1000;
                    break;
                case 'D':
                    ans += (subC) ? 300 : 500;
                    break;
                case 'C':
                    ans += (subX) ? 80 : 100;
                    subC = true;
                    break;
                case 'L':
                    ans += (subX) ? 30 : 50;
                    break;
                case 'X':
                    ans += (subI) ? 8 : 10;
                    subX = true;
                    break;
                case 'V':
                    ans += (subI) ? 3 : 5;
                    break;
                case 'I':
                    ans += 1;
                    subI = true;
                    break;
            }
        }
        return ans;
    }

    static void main(String[] args) {

        System.out.println("13. Roman to Integer\n");

        // example 1
        String s1 = "XCI";
        System.out.println(s1 + " = " + romanToInt(s1) + "\n");

        // example 2
        String s2 = "CDI";
        System.out.println(s2 + " = " + romanToInt(s2) + "\n");
    }
}
