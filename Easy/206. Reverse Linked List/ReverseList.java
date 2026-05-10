import java.util.Arrays;

public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode curr = head; // move pointer
        ListNode prev = null; // 1 node behind curr

        while(curr != null) { // reverse direction of every node

            ListNode next = curr.next;
            // when you changed the direction of curr to the left, all the right
            // nodes will be gone unless you set a node forward to the left first
            curr.next = prev;
            // carefully move prev since curr has a hold of the left nodes now
            prev = curr;
            // carefully move curr since prev has a hold of the left nodes now
            curr = next;
        }

        return prev; // where curr is null and prev is last node in reversed direction
    }

    public static void main(String[] args) {

        System.out.println("206. Reverse Linked List");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        System.out.print("\nORG: " + Arrays.toString(a1) + "\nREV: ");
        ListNode h1 = buildList(a1);
        printList(reverseList(h1));

        // example 2
        int[] a2 = {};
        System.out.print("\nORG: " + Arrays.toString(a2) + "\nREV: ");
        ListNode h2 = buildList(a2);
        printList(reverseList(h2));
    }

    public static void printList(ListNode head) {

        System.out.print("[");

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) System.out.print(", ");

            head = head.next;
        }
        System.out.print("]\n");
    }

    public static ListNode buildList(int[] arr) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int val : arr) {

            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
    }
}
