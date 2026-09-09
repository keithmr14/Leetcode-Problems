package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class RemoveNthNode {

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        if(n < 1) throw new IllegalArgumentException("n of " + n + " must be greater than 0");

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        ListNode prev = dummy; // node before delete node
        ListNode delete = dummy;

        int distance = 0;
        while(curr.next != null) {

            distance++;
            curr = curr.next;

            if(distance == n) delete = head; // slow pointer

            else if(distance > n) {
                prev = delete;
                delete = delete.next;
            }
        }
        if(n > distance) throw new IllegalArgumentException(
                "n of " + n + " must be between 1 and list length " + distance);

        prev.next = delete.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("19. Remove Nth Node From End of List");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        int n1 = 5;
        ListNode h1 = buildList(a1);
        System.out.println("\nn = " + n1);
        System.out.println("List: " + Arrays.toString(a1));
        System.out.print("New List: ");
        printList(removeNthFromEnd(h1, n1));

        // example 2
        int[] a2 = {1};
        int n2 = 1;
        ListNode h2 = buildList(a2);
        System.out.println("\nn = " + n2);
        System.out.println("List: " + Arrays.toString(a2));
        System.out.print("New List: ");
        printList(removeNthFromEnd(h2, n2));
    }
}
