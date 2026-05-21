import java.util.Arrays;
import java.util.Stack;

public class SpecialDiscount {

    public static int[] finalPrices(int[] prices) {

        int n = prices.length;

        // The best case for this problem is if the prices are in
        // non-decreasing order. We will best emulate this by making
        // a stack of non-decreasing prices (not sorted but by removing
        // increasing elements).

        Stack<Integer> nonDec = new Stack<>();

        for(int i = n - 1; i >= 0; i--) { // start at the last index

            int price = prices[i];

            // continue checking for lesser num on the right until empty
            while(!nonDec.empty()) {

                int top = nonDec.peek();

                if(top <= price) { // check for the nearest lesser num
                    prices[i] -= top; // apply discount
                    break; // terminate loop
                }
                // if price is lesser than the ones on stack, pop them
                else nonDec.pop();
            }
            // push price, since it has no num/lesser num on the right
            nonDec.push(price);
        }
        return prices; // return the updated prices
    }

    public static void main(String[] args) {

        System.out.println("1475. Final Prices With a Special Discount in a Shop");

        // example 1
        int[] a1 = {8, 4, 6, 2, 3};
        System.out.println("\nPrices: " + Arrays.toString(a1));
        System.out.println("Discounted: " + Arrays.toString(finalPrices(a1)));

        // example 2
        int[] a2 = {1, 2, 3, 4, 5};
        System.out.println("\nPrices: " + Arrays.toString(a2));
        System.out.println("Discounted: " + Arrays.toString(finalPrices(a2)));
    }
}
