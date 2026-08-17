package medium;

import utils.ListNode;
import java.util.*;
import static utils.ListUtils.*;

public class TwinSum {

    public static int pairSum(ListNode head) {

        if(head == null) throw new IllegalArgumentException("list mustn't be empty");

        ListNode half = new ListNode();
        half.next = head;
        ListNode fast = half;
        int maxTwin = Integer.MIN_VALUE;
        Stack<Integer> firstHalf = new Stack<>();

        while(fast.next != null) {

            half = half.next;
            firstHalf.push(half.val);
            fast = fast.next.next;
            if(fast == null) throw new IllegalArgumentException("list length must be even");
        }

        while(half.next != null) {

            half = half.next; // go through the second half
            int firstNum = firstHalf.pop();
            try {
                int twinSum = Math.addExact(half.val, firstNum);
                maxTwin = Math.max(maxTwin, twinSum);
            }
            catch(ArithmeticException e) { throw new ArithmeticException(
                    "exception from " + firstNum + " + " + half.val + " due to integer overflow"); }
        }

        return maxTwin;
    }

    public static void main(String[] args) {

        System.out.println("2130. Maximum Twin Sum of a Linked List");

        // example 1
        int[] a1 = {5, 4, 2, 1};
        ListNode h1 = buildList(a1);
        System.out.println("\nSingly List: " + Arrays.toString(a1));
        System.out.println("Max Twin Sum: " + pairSum(h1));

        // example 2
        int[] a2 = {1, 100000};
        ListNode h2 = buildList(a2);
        System.out.println("\nSingly List: " + Arrays.toString(a2));
        System.out.println("Max Twin Sum: " + pairSum(h2));
    }
}
