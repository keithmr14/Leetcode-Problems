package easy;

import utils.ListNode;
import java.util.Arrays;
import static utils.ListUtils.*;

public class ReverseList {

    public static ListNode reverseList(ListNode head) {

        ListNode curr = head;
        ListNode prev = null;

        while(curr != null) {

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // where curr is null and prev is the last reversed node (head)
        return prev;
    }

    public static void main(String[] args) {

        System.out.println("206. Reverse Linked List");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        ListNode h1 = buildList(a1);
        System.out.println("\nSingly List: " + Arrays.toString(a1));
        System.out.print("Reversed List: ");
        printList(reverseList(h1));

        // example 2
        int[] a2 = {};
        ListNode h2 = buildList(a2);
        System.out.println("\nSingly List: " + Arrays.toString(a2));
        System.out.print("Reversed List: ");
        printList(reverseList(h2));
    }
}
