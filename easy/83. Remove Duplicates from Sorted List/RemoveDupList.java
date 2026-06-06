public class RemoveDupList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(); // -1 result pointer
        ListNode curr = dummy; // insert pointer

        int lastNum = -101; // out of bound input instead of null

        while(head != null) { // head as the traversal pointer

            if(head.val != lastNum) {

                lastNum = head.val; // mark value as last seen
                curr.next = head; // record unique value only
                curr = curr.next; // move insert pointer
            }

            head = head.next; // move through the list
        }

        curr.next = null; // close any connection to original list

        return dummy.next; // return result
    }

    public static void main(String[] args) {

        System.out.println("83. Remove Duplicates from Sorted List");

        // example 1
        int[] a1 = {};
        ListNode h1 = buildList(a1);
        System.out.print("\nw/ Duplicates: ");
        printList(h1);
        System.out.print("w/o Duplicates: ");
        printList(deleteDuplicates(h1));


        // example 2
        int[] a2 = {1, 1, 2, 3, 3};
        ListNode h2 = buildList(a2);
        System.out.print("\nw/ Duplicates: ");
        printList(h2);
        System.out.print("w/o Duplicates: ");
        printList(deleteDuplicates(h2));
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
