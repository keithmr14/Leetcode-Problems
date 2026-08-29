package easy;

import java.util.Arrays;

public class MinCostCandy {

    public static int minimumCost(int[] cost) {

        Arrays.sort(cost);
        int candies = 1;
        int minCost = 0;

        for(int i = cost.length -1; i >= 0; i--) {

            if(candies % 3 != 0) {
                try {
                    minCost = Math.addExact(minCost, cost[i]);

                } catch(ArithmeticException e) {
                    throw new IllegalArgumentException("exception from " + minCost
                            + " + " + cost[i] + " due to integer overflow"); }
            }
            candies++;
        }

        return minCost;
    }

    public static void main(String[] args) {

        System.out.println("2144. Minimum Cost of Buying Candies With Discount");

        // example 1
        int[] a1 = {1, 2, 3};
        System.out.println("\nCandies: " + Arrays.toString(a1));
        System.out.println("Minimum Cost: " + minimumCost(a1));

        // example 2
        int[] a2 = {6, 5, 7, 9, 2, 2};
        System.out.println("\nCandies: " + Arrays.toString(a2));
        System.out.println("Minimum Cost: " + minimumCost(a2));
    }
}
