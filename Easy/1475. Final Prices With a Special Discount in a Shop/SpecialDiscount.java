import java.util.Arrays;
import java.util.Stack;

public class SpecialDiscount {

    public static int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>(); // stack of checked but undiscounted prices

        for(int i = 0; i < prices.length; i++) {

            int price = prices[i]; // won't change

            while(!stack.empty()) {

                int topI = stack.peek();

                if(price > prices[topI]) break; // if > than the biggest num prior

                // else: apply discount, pop, & see if price is still <= to the rest of the stack
                prices[topI] -= price;
                stack.pop();
            }

            stack.push(i); // when all comparison done
        }

        return prices; // updated prices
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
