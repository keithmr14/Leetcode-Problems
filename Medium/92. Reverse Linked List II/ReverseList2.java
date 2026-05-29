public class ReverseList2 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0); // -1 return pointer
        dummy.next = head; // connect dummy to list
        ListNode curr = head; // traversal pointer
        ListNode nodeInRange = new ListNode(); // pointer for left, right, and in between
        ListNode beforeleft = dummy; // node before left's node

        for(int i = 1; i <= left; i++) { // for each node position

            if(i + 1 == left) { // if beforeLeft was found first

                beforeleft = curr; // set beforeLeft
                nodeInRange = curr.next; // left's node is found
                break; // no need to find left's node
            }
            // If beforeLeft is not seen because left's node is the first node,
            // beforeLeft is in dummy for this matter.
            if(i == left) nodeInRange = curr;

            else curr = curr.next; // continue to find the left's node
        }

        ListNode tail = nodeInRange; // tail of the reverse range
        ListNode prev = tail; // when reversing node, point those node to prev

        // tail can't be reversed yet without the afterTail, so start reversing at the next of left's node
        nodeInRange = nodeInRange.next;
        left++;

        while(left <= right) { // continue until right's node is reversed

            if(left == right) { // if the right's node is next to be reversed

                ListNode afterTail = nodeInRange.next; // hold the node after right's node
                nodeInRange.next = prev; // reverse right's node
                beforeleft.next = nodeInRange; // beforeLeft connects to the right's node
                tail.next = afterTail; // left's node connects to the node afterTail
            }
            else { // reverse nodes in reverse range

                ListNode next = nodeInRange.next; // hold the node after nodeInRange
                nodeInRange.next = prev; // reverse node
                prev = nodeInRange; // move prev
                nodeInRange = next; // move nodeInRange
            }
            // reduce int distance because we don't have reference to the right's
            // node to track it against nodeInRange
            left++;
        }
        // since we've potentially only changed the direction of the first node,
        // it is still connected to dummy
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
