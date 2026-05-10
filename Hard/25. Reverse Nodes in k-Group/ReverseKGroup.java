import java.util.Arrays;

public class ReverseKGroup {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode curr = head; // move pointer, next to be reversed node

        // 1 node behind curr, last reversed node, head of every reversed group
        ListNode prev = null;

        ListNode lastTail = new ListNode(0); // for use
        ListNode dummy = new ListNode(0); // for result

        int n = 0; // list size

        // count the number of nodes
        for(ListNode count = head; count != null; count = count.next) { n++; }

        int groups = n / k; // determine the number of groups

        // for each k-group, reverse their corresponding nodes
        for(int g = 1; g <= groups; g++) {

            ListNode tail = curr; // define tail of k-group

            // reverse direction of every node in a k-group
            for(int i = 1; i <= k; i++) {

                ListNode next = curr.next;
                // when you changed the direction of curr to the left, all the right
                // nodes will be gone unless you set a node forward to the left first
                curr.next = prev;
                // carefully move prev since curr has a hold of the left nodes now
                prev = curr;
                // carefully move curr since prev has a hold of the left nodes now
                curr = next;
            }

            // if it's the first k-group, this group's head is the result head
            if(g == 1) dummy.next = prev;
            // if it's not the first k-group, connect group's head to the last group's tail
            else lastTail.next = prev;

            lastTail = tail; // record tail
        }

        lastTail.next = curr; // connect the last reversed node to null or non-reversed nodes

        return dummy.next; // return result
    }

    public static void main(String[] args) {

        System.out.println("25. Reverse Nodes in k-Group");

        // example 1
        int[] a1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.print("\nORG: " + Arrays.toString(a1) + " k = "+ k1 + "\nREV: ");
        ListNode h1 = buildList(a1);
        printList(reverseKGroup(h1, k1));

        // example 2
        int[] a2 = {1, 2, 3, 4, 5, 6};
        int k2 = 3;
        System.out.print("\nORG: " + Arrays.toString(a2) + " k = "+ k2 + "\nREV: ");
        ListNode h2 = buildList(a2);
        printList(reverseKGroup(h2, k2));
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
