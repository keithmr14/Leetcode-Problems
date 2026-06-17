package hard;

public class ProcessString2 {

    public static char processStr(String s, long k) {

        if(k < 0) throw new IllegalArgumentException("k cannot be negative");

        long length = 0;

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z') length++;

            else if(c == '*') {

                if(length != 0) length--;
            }
            else if (c == '#') length *= 2;

            else if(c != '%') throw new IllegalArgumentException("invalid character found");
        }

        if(k > length - 1) return '.';

        for (int i = s.length() - 1; i >= 0; i--) {

            char c = s.charAt(i);

            if (c >= 'a' && c <= 'z') {

                if (k == length - 1) return c;
                length--;
            }
            else if (c == '*') length++;

            else if (c == '#') {

                length /= 2;
                if (k >= length) k -= length;
            }
            else if (c == '%') k = length - 1 - k;
        }

        return '.';
    }

    public static void main(String[] args) {

        System.out.println("3614. Process String with Special Operations II");

        String s1 = "cd%#*#";
        long k1 = 3;
        System.out.println("\nk: " + k1 + "    String: " + s1);
        System.out.println("Character at k: " + processStr(s1, k1));

        String s2 = "a#b%*";
        long k2 = 1;
        System.out.println("\nk: " + k2 + "    String: " + s2);
        System.out.println("Character at k: " + processStr(s2, k2));
    }
}
