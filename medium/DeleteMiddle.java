package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class DeleteMiddle {

    public static ListNode deleteMiddle(ListNode head) {

        if(head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode middle = dummy;
        ListNode fast = dummy;

        while(fast.next != null) {

            fast = fast.next.next;
            if(fast == null) break;
            middle = middle.next;
        }

         middle.next = middle.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("2095. Delete the Middle Node of a Linked List");

        // example 1
        int[] a1 = {1,3,4,7,1,2,6};
        ListNode h1 = buildList(a1);
        System.out.println("\nSingly List: " + Arrays.toString(a1));
        System.out.print("Updated List: ");
        printList(deleteMiddle(h1));

        // example 2
        int[] a2 = {1,2,3,4};
        ListNode h2 = buildList(a2);
        System.out.println("\nSingly List: " + Arrays.toString(a2));
        System.out.print("Updated List: ");
        printList(deleteMiddle(h2));
    }
}
