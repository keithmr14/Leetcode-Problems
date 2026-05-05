import java.util.Arrays;

public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {

            return head; // edge cases
        }

        ListNode curr = head; // move pointer

        int n = 1; // length of the list

        while(curr.next != null) { // count each node

            curr = curr.next;
            n++;
        }

        k = k % n; // count how many rotates outside of full rotation

        if(k == 0) return head; // if rotation results back to original

        int cut = n - k; // where first and last node meet when rotated

        curr.next = head; // make the last and first node connected

        for(int i = 1; i <= cut; i++) { // traverse to cut

            curr = curr.next;
        }

        head = curr.next; // cut

        curr.next = null; // cut

        return head;
    }

    public static void main(String[] args) {

        System.out.println("61. Rotate List\n");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        ListNode h1 = buildList(a1);
        ListNode r1 = rotateRight(h1, 2);
        System.out.println(Arrays.toString(a1) + " k = " + 2);
        printList(r1);

        // example 2
        int[] a2 = {0, 1, 2};
        ListNode h2 = buildList(a2);
        ListNode r2 = rotateRight(h2, 4);
        System.out.println(Arrays.toString(a2) + " k = " + 4);
        printList(r2);
    }

    public static void printList(ListNode head) {

        System.out.print("[");

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) System.out.print(", ");

            head = head.next;
        }
        System.out.print("]\n\n");
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
