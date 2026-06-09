package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {

        if(k < 0) throw new IllegalArgumentException("k is invalid");

        if(head == null || head.next == null || k == 0) return head;

        ListNode curr = head;
        int n = 1;

        while(curr.next != null) { curr = curr.next; n++; }

        curr.next = head; // connect both ends
        k = k % n;
        int newHeadAt = n - k - 1; // 1 node before the new head index (before rotation, 0-indexed)

        for(int i = 0; i <= newHeadAt; i++) { curr = curr.next; }

        head = curr.next;
        curr.next = null;

        return head;
    }

    public static void main(String[] args) {

        System.out.println("61. Rotate List");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        ListNode h1 = buildList(a1);
        System.out.println("\nShift Right: " + k1 + "    Array: " +  Arrays.toString(a1));
        System.out.print("Rotated: ");
        printList(rotateRight(h1, k1));

        // example 2
        int[] a2 = {0, 1, 2};
        int k2 = 4;
        ListNode h2 = buildList(a2);
        System.out.println("\nShift Right: " + k2 + "    Array: " +  Arrays.toString(a2));
        System.out.print("Rotated: ");
        printList(rotateRight(h2, k2));
    }
}
