package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class ReverseList2 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if(head == null) throw new IllegalArgumentException("list mustn't be empty");
        if(left < 1) throw new IllegalArgumentException(
                "left and right must be greater than or equal to 1");
        if(left > right) throw new IllegalArgumentException(
                "left " + left + " must be less than or equal to right " + right);

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = head;
        ListNode nodeInRange = null; // pointer for left, right, and in-between
        ListNode beforeleft = dummy; // one node before left when left = 1, or update this

        for(int i = 1; i <= left; i++) { // stop on or before left's node

            if(curr == null) throw new IllegalArgumentException(
                    "left " + left + " mustn't be greater than list length " + --i);

            if(i + 1 == left) {
                beforeleft = curr;
                nodeInRange = curr.next;
                break;
            }
            if(i == left) nodeInRange = curr;
            else curr = curr.next;
        }
        if (nodeInRange == null) throw new IllegalArgumentException(
                "left " + left + " mustn't be greater than list length " + --left);
        if(left == right) return dummy.next;

        ListNode tail = nodeInRange; // tail of the reverse range
        ListNode prev = tail; // when reversing node, point those nodes to prev
        // tail doesn't have a node to point to yet, so start reversing at the next of left's node
        nodeInRange = nodeInRange.next;
        left++;

        while(left <= right) {

            if(nodeInRange == null) throw new IllegalArgumentException(
                    "right " + right + " mustn't be greater than list length " + --left);

            if(left == right) { // reverse the right's node
                ListNode afterRight = nodeInRange.next;
                nodeInRange.next = prev;
                beforeleft.next = nodeInRange;
                tail.next = afterRight;

            } else { // reverse in-between nodes
                ListNode next = nodeInRange.next;
                nodeInRange.next = prev;
                prev = nodeInRange;
                nodeInRange = next;
            }
            left++;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("92. Reverse Linked List II");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        int l1 = 2;
        int r1 = 4;
        ListNode h1 = buildList(a1);
        System.out.println("\nList: " + Arrays.toString(a1));
        System.out.println("Left: " + l1 + " Right: " + r1);
        System.out.print("Reversed: ");
        printList(reverseBetween(h1, l1, r1));

        // example 2
        int[] a2 = {5};
        int l2 = 1;
        int r2 = 1;
        ListNode h2 = buildList(a2);
        System.out.println("\nList: " + Arrays.toString(a2));
        System.out.println("Left: " + l2 + " Right: " + r2);
        System.out.print("Reversed: ");
        printList(reverseBetween(h2, l2, r2));
    }
}
