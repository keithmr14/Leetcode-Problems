package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class SwapNodePairs {

    public static ListNode swapPairs(ListNode head) {
        
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode lastTail = dummy; // tail of the previous pair, 1 node before first entry
        ListNode tail = head;
        boolean isFirstEntry = true;

        while(curr != null) {
            if(isFirstEntry) {
                tail = curr; // to be switched with the second entry
                curr = curr.next;
                isFirstEntry = false;

            } else { // second entries only
                ListNode next = curr.next;
                curr.next = tail;
                tail.next = next;
                lastTail.next = curr;
                lastTail = tail;
                curr = next;
                isFirstEntry = true;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("24. Swap Nodes in Pairs");
        // example 1
        int[] a1 = {1, 2, 3, 4};
        ListNode l1 = buildList(a1);
        System.out.println("\nSingly List: " + Arrays.toString(a1));
        System.out.print("Swapped Pairs: ");
        printList(swapPairs(l1));
        // example 2
        int[] a2 = {1, 2, 3};
        ListNode l2 = buildList(a2);
        System.out.println("\nSingly List: " + Arrays.toString(a2));
        System.out.print("Swapped Pairs: ");
        printList(swapPairs(l2));
    }
}
