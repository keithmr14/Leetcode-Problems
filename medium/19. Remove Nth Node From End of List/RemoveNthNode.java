import java.util.Arrays;

public class RemoveNthNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0); // -1 pointer
        dummy.next = head; // connect to the head node
        ListNode curr = head; // move until it reaches the end node

        // setting these two nodes to dummy is important because they might
        // need to delete the first node (head) and readjust the pointers
        ListNode prev = dummy; // node before the delete node
        ListNode del = dummy; // pointer for the node to be deleted

        // move curr through the last node but create distance before
        // creating the prev and del node (k for distance)
        for(int k = 1; curr != null; k++) {

            if(k == n) del = head; // create del node at the exact distance n

            else if(k > n) {
                // if del node was already created, create prev node and
                // move both of them simultaneously with curr node
                prev = del;
                del = del.next;
            }
            curr = curr.next;
        }

        prev.next = del.next; // skip del node (delete)

        return dummy.next; // return head
    }

    public static void main(String[] args) {

        System.out.println("19. Remove Nth Node From End of List");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        System.out.print("\nORG: " + Arrays.toString(a1) + "  n = 2\nNEW: ");
        ListNode h1 = buildList(a1);
        printList(removeNthFromEnd(h1, 2));

        // example 2
        int[] a2 = {1};
        System.out.print("\nORG: " + Arrays.toString(a2) + "  n = 1\nNEW: ");
        ListNode h2 = buildList(a2);
        printList(removeNthFromEnd(h2, 1));
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
