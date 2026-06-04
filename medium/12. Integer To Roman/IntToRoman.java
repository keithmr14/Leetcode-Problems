public class IntToRoman {

    public static String intToRoman(int num) {

        StringBuilder ans = new StringBuilder();

        // deduct the number everytime a roman symbol is added
        while(num > 0) {

            // how many digits are in a number
            int length = String.valueOf(num).length();
            int digit; // get the leading digit

            switch(length) {
                // calculate special cases base on the current
                // place value and leading digit
                case 4:
                    ans.append("M");
                    num -= 1000;
                    break;

                case 3:
                    digit = num / 100;

                    if(digit == 9) {
                        ans.append("CM");
                        num -= 900;
                    }
                    else if(digit >= 5) {
                        ans.append("D");
                        num -= 500;
                    }
                    else if(digit == 4) {
                        ans.append("CD");
                        num -= 400;
                    }
                    else {
                        ans.append("C");
                        num -= 100;
                    }
                    break;

                case 2:
                    digit = num / 10;

                    if(digit == 9) {
                        ans.append("XC");
                        num -= 90;
                    }
                    else if(digit >= 5) {
                        ans.append("L");
                        num -= 50;
                    }
                    else if(digit == 4){
                        ans.append("XL");
                        num -= 40;
                    }
                    else {
                        ans.append("X");
                        num -= 10;
                    }
                    break;

                case 1:
                    if(num == 9) {
                        ans.append("IX");
                        num -= 9;
                    }
                    else if(num >= 5) {
                        ans.append("V");
                        num -= 5;
                    }
                    else if(num == 4){
                        ans.append("IV");
                        num -= 4;
                    }
                    else {
                        ans.append("I");
                        num--;
                    }
                    break;
            }
        }
        return String.valueOf(ans);
    }

    static void main(String[] args) {

        System.out.println("12. Integer To Roman\n");

        // example 1
        int n1 = 91;
        System.out.println(n1 + " = " + intToRoman(n1) + "\n");

        // example 2
        int n2 = 401;
        System.out.println(n2 + " = " + intToRoman(n2) + "\n");
    }
}