package medium;

public class ProcessString1 {

    public static String processStr(String s) {

        StringBuilder sb = new StringBuilder();
        int lastIndex = -1;

        for(int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if(c >= 'a' && c <= 'z') {
                sb.append(c);
                lastIndex++;
            }
            else if(c == '*') {

                if(lastIndex != -1) {
                    sb.deleteCharAt(lastIndex);
                    lastIndex--;
                }
            }
            else if (c == '#') {

                sb.append(sb);
                lastIndex = (lastIndex + 1) * 2;
                lastIndex--;
            }
            else if(c == '%') sb.reverse();

            else throw new IllegalArgumentException("invalid character '" + c + "' found");
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        System.out.println("3612. Process String with Special Operations I");

        // example 1
        String s1 = "a#b%*";
        System.out.println("\nString: " + s1);
        System.out.println("Result: " + processStr(s1));

        // example 2
        String s2 = "z*#";
        System.out.println("\nString: " + s2);
        System.out.println("Result: " + processStr(s2));
    }
}
