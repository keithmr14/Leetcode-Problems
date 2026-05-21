import java.util.Arrays;
import java.util.Stack;

public class SpecialDiscount {

    public static int[] finalPrices(int[] prices) {

        int n = prices.length;

        // The best case for this problem is if the prices are in
        // non-increasing order. We will best emulate this by making
        // a stack of non-increasing prices (not sorted but by removing
        // increasing elements).

        Stack<Integer> nonInc = new Stack<>();

        for(int i = n - 1; i >= 0; i--) { // start at the last index

            int price = prices[i];

            // continue checking for lesser num on the right until empty
            while(!nonInc.empty()) {

                int top = nonInc.peek();

                if(top <= price) { // check for the nearest lesser num
                    prices[i] -= top; // apply discount
                    break; // terminate loop
                }
                // if the price on stack is greater than current price, pop them
                else nonInc.pop();
            }
            // push price, since it has greater num (or no num) on the right
            nonInc.push(price);
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
