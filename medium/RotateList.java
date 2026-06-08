package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class RotateList {

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) { return head; }
        
        ListNode curr = head;
        int n = 1;
        
        // go to the last node
        while(curr.next != null) { curr = curr.next; n++; }

        curr.next = head; // connect both ends
        k = k % n;
        int cut = n - k; // node before the new head
        
        for(int i = 1; i <= cut; i++) { curr = curr.next; }

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
        System.out.println("\nk = " + k1 + "    " +  Arrays.toString(a1));
        System.out.print("Rotated: ");
        printList(rotateRight(h1, k1));
        
        // example 2
        int[] a2 = {0, 1, 2};
        int k2 = 4;
        ListNode h2 = buildList(a2);
        System.out.println("\nk = " + k2 + "    " +  Arrays.toString(a2));
        System.out.print("Rotated: ");
        printList(rotateRight(h2, k2));
    }
}
