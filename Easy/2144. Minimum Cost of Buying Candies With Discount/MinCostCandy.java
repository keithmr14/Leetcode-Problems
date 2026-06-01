import java.util.Arrays;

public class MinCostCandy {

    public static int minimumCost(int[] cost) {

        Arrays.sort(cost); // sort in ascending order
        int n = cost.length;
        int minCost = 0;
        int i = n - 1; // start at the most expensive candy

        for(int free = n / 3; free > 0; free--) {
            // for every 3 most expensive candy, get the cheapest of 3 for free
            minCost += cost[i] + cost[--i];
            i -= 2;
        }

        while(i >= 0) {
            // buy any 1 or 2 candies left that can't apply discount
            minCost += cost[i];
            i--;
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
