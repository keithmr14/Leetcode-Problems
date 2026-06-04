import java.util.Arrays;

public class SwapNodePairs {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode swapPairs(ListNode head) {

        ListNode dummy = new ListNode(); // -1 print pointer
        dummy.next = head; // connect dummy
        ListNode curr = head; // traversal pointer
        ListNode lastTail = dummy; // tail of the previous pair, 1 node before first entry
        ListNode tail = new ListNode(); // the tail of a pair
        boolean isFirstEntry = true; // is curr the first entry of a pair

        while(curr != null) { // while there's any node next

            if(isFirstEntry) {

                tail = curr; // to be switched with the second entry
                curr = curr.next;
                isFirstEntry = false;
            }
            else {

                ListNode next = curr.next; // hold the next first entry
                curr.next = tail; // switch node direction
                tail.next = next; // skip curr
                lastTail.next = curr; // obtain the head of the pair
                lastTail = tail; // record this tail
                curr = next; // go to the next first entry
                isFirstEntry = true;

            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("24. Swap Nodes in Pairs");

        // example 1
        int[] a1 = {1, 2, 3, 4};
        ListNode l1 = buildList(a1);
        System.out.println("\nSingly List: " + Arrays.toString(a1));
        System.out.print("Swapped Pairs: ");
        printList(swapPairs(l1));

        // example 2
        int[] a2 = {1, 2, 3};
        ListNode l2 = buildList(a2);
        System.out.println("\nSingly List: " + Arrays.toString(a2));
        System.out.print("Swapped Pairs: ");
        printList(swapPairs(l2));
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
