package easy;

import utils.ListNode;
import static utils.ListUtils.*;

public class RemoveDupList {

    public static ListNode deleteDuplicates(ListNode head) {

        // remove this to reduce runtime in leetCode, but add it outside leetCode
        if(!isNonDecreasingList(head)) throw new IllegalArgumentException("list must be non-decreasing");

        if(head == null) return null;

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode valid = head;
        int lastNum = head.val;
        head = head.next;

        while(head != null) {

            if(head.val != lastNum) {

                lastNum = head.val;
                valid.next = head;
                valid = valid.next;
            }
            head = head.next;
        }
        valid.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("83. Remove Duplicates from Sorted List");

        // example 1
        int[] a1 = {};
        ListNode h1 = buildList(a1);
        System.out.print("\nWith Duplicates: ");
        printList(h1);
        System.out.print("Without Duplicates: ");
        printList(deleteDuplicates(h1));

        // example 2
        int[] a2 = {1, 1, 2, 3, 3};
        ListNode h2 = buildList(a2);
        System.out.print("\nWith Duplicates: ");
        printList(h2);
        System.out.print("Without Duplicates: ");
        printList(deleteDuplicates(h2));
    }
}
