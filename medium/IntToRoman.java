package medium;

public class IntToRoman {

    public static String intToRoman(int num) {

        if(num < 1 || num > 3999) throw new IllegalArgumentException("integer must greater than 0 and less than 4000");

        StringBuilder roman = new StringBuilder();

        while(num > 0) { // deduct the number everytime a roman symbol is added

            int length = String.valueOf(num).length();
            int leadDigit;
            // calculate the roman equivalent based on current place value and leading digit
            switch(length) {
                case 4:
                    roman.append("M");
                    num -= 1000;
                    break;
                case 3:
                    leadDigit = num / 100;
                    if(leadDigit == 9) { roman.append("CM"); num -= 900; }
                    else if(leadDigit >= 5) { roman.append("D"); num -= 500; }
                    else if(leadDigit == 4) { roman.append("CD"); num -= 400; }
                    else { roman.append("C"); num -= 100; }
                    break;
                case 2:
                    leadDigit = num / 10;
                    if(leadDigit == 9) { roman.append("XC"); num -= 90; }
                    else if(leadDigit >= 5) { roman.append("L"); num -= 50; }
                    else if(leadDigit == 4){ roman.append("XL"); num -= 40; }
                    else { roman.append("X"); num -= 10; }
                    break;
                case 1:
                    if(num == 9) { roman.append("IX"); num -= 9; }
                    else if(num >= 5) { roman.append("V"); num -= 5; }
                    else if(num == 4){ roman.append("IV"); num -= 4; }
                    else { roman.append("I"); num--; }
                    break;
            }
        }
        return String.valueOf(roman);
    }

    public static void main(String[] args) {

        System.out.println("12. Integer To Roman");

        // example 1
        int n1 = 91;
        System.out.println("\nInteger: " + n1);
        System.out.println("Roman: " + intToRoman(n1)); // 91 = XCI

        // example 2
        int n2 = 401;
        System.out.println("\nInteger: " + n2);
        System.out.println("Roman: " + intToRoman(n2)); // 401 = CDI
    }
}
