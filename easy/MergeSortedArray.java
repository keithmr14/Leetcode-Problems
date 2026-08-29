package easy;

import utils.ListNode;
import java.util.Arrays;
import static utils.ListUtils.*;

public class MergeTwoList {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // remove this to reduce runtime in leetCode, but add it outside leetCode
        if(!(isNonDecreasingList(list1) && isNonDecreasingList(list2)))
            throw new IllegalArgumentException("both lists must be non-decreasing");

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(list1 != null || list2 != null) {

            boolean l1Null = (list1 == null);
            boolean l2Null = (list2 == null);

            if (l2Null) { curr.next = list1; break; }

            else if(l1Null) { curr.next = list2; break; }

            else {
                if(list1.val < list2.val) {
                    // when list1 value is less than, add it to merged
                    curr.next = list1;
                    curr = curr.next;
                    list1 = list1.next;
                }
                else if(list2.val < list1.val) {
                    // when list2 value is less than, add it to merged
                    curr.next = list2;
                    curr = curr.next;
                    list2 = list2.next;
                }
                else {
                    // if equal, add both to merged
                    curr.next = list1;
                    curr = curr.next;
                    list1 = list1.next;
                    curr.next = list2;
                    curr = curr.next;
                    list2 = list2.next;
                }
            }
        }

        return dummy.next; // return merged list
    }

    public static void main(String[] args) {

        System.out.println("21. Merged Two Sorted Lists");

        // example 1
        int[] a1 = {1, 2, 4};
        int[] a2 = {1, 3, 4};
        ListNode l1 = buildList(a1);
        ListNode l2 = buildList(a2);
        System.out.println("\nList 1: " + Arrays.toString(a1));
        System.out.println("List 2: " + Arrays.toString(a2));
        System.out.print("Merged List: ");
        printList(mergeTwoLists(l1, l2));

        // example 2
        int[] b1 = {};
        int[] b2 = {0};
        l1 = buildList(b1);
        l2 = buildList(b2);
        System.out.println("\nList 1: " + Arrays.toString(b1));
        System.out.println("List 2: " + Arrays.toString(b2));
        System.out.print("Merged List: ");
        printList(mergeTwoLists(l1, l2));
    }
}
