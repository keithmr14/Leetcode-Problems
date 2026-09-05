package easy;

import java.util.*;

public class SpecialDiscount {

    public static int[] finalPrices(int[] prices) {

        // stack remains non-decreasing (bottom-to-top) by design
        Stack<Integer> seenIndex = new Stack<>();

        for(int i = 0; i < prices.length; i++) {

            int price = prices[i];

            while(!seenIndex.empty()) {

                int topI = seenIndex.peek();

                if(price > prices[topI]) break;

                prices[topI] -= price;
                seenIndex.pop();
            }
            seenIndex.push(i);
        }
        return prices;
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
