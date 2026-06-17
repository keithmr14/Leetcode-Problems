package hard;

public class ProcessString2 {

    public char processStr(String s, long k) {

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
}
