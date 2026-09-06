package hard;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        if(k == 1) return head;

        if(k < 1) throw new IllegalArgumentException("k of " + k + " must be greater than 0");

        ListNode curr = head; // next to be reversed node
        ListNode prev = null; // 1 node behind curr, head of every reversed group
        ListNode lastTail = new ListNode();
        ListNode dummy = new ListNode();
        int n = 0;

        for(ListNode count = head; count != null; count = count.next) { n++; }

        if(n < k) return head;

        int groups = n / k;

        for(int g = 1; g <= groups; g++) {

            ListNode tail = curr;
            // k is the number of nodes in each group
            for(int i = 1; i <= k; i++) {

                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }

            if(g == 1) dummy.next = prev;
            else lastTail.next = prev;

            lastTail = tail;
        }

        lastTail.next = curr; // curr is in null or non-reversed nodes
        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("25. Reverse Nodes in k-Group");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode h1 = buildList(a1);
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Node per Group (k): " + k1);
        System.out.print("Reversed k-Groups: ");
        printList(reverseKGroup(h1, k1));

        // example 2
        int[] a2 = {1, 2, 3, 4, 5, 6};
        int k2 = 3;
        ListNode h2 = buildList(a2);
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Node per Group (k): " + k2);
        System.out.print("Reversed k-Groups: ");
        printList(reverseKGroup(h2, k2));
    }
}
