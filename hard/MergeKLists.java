package hard;

import utils.ListNode;
import static utils.ArrayUtils.*;
import static utils.ListUtils.*;

public class MergeKLists {

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int min = findMinHeadIndex(lists);

        while(min != -1) { // findMinHeadIndex returns -1 if all list are empty

            curr.next = lists[min];
            curr = curr.next;

            while(curr.next != null) {

                ListNode next = curr.next;

                if(next.val < curr.val) throw new IllegalArgumentException("a list was not sorted increasingly");

                if(next.val == curr.val) curr = curr.next;

                else break;
            }

            lists[min] = curr.next;
            min = findMinHeadIndex(lists);
        }

        return dummy.next;
    }

    public static int findMinHeadIndex(ListNode[] lists) {

        int min = -1;

        for(int i = 0; i < lists.length; i++) {

            if(lists[i] == null) continue;

            if(min == -1) min = i;

            else if(lists[i].val < lists[min].val) min = i;
        }
        return min;
    }

    public static void main(String[] args) {

        System.out.println("23. Merge k Sorted Lists");

        // example 1
        int[][] a1 = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        System.out.print("\nArray of List: ");
        print2dIntOneLine(a1);
        System.out.print("\nMerged List: ");
        printList(mergeKLists(buildArrayOfList(a1)));

        // example 2
        int[][] a2 = {{}, {}};
        System.out.print("\nArray of List: ");
        print2dIntOneLine(a2);
        System.out.print("\nMerged List: ");
        printList(mergeKLists(buildArrayOfList(a2)));
    }
}
