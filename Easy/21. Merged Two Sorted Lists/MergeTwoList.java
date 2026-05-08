import java.util.Arrays;

public class MergeTwoList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0); // -1 pointer
        ListNode curr = dummy; // move pointer

        while(list1 != null || list2 != null) { // while both aren't empty

            boolean l1Null = (list1 == null);
            boolean l2Null = (list2 == null);

            if (l2Null) {
                // when list2 is already empty, copy the rest of list1
                curr.next = list1;
                break;
            }
            else if(l1Null) {
                // when list1 is already empty, copy the rest of list2
                curr.next = list2;
                break;
            }
            else { // when both list are not empty

                if(list1.val < list2.val) {
                    // when list1 value is less than, copy it
                    curr.next = list1;
                    curr = curr.next;
                    list1 = list1.next;
                }
                else if(list2.val < list1.val) {
                    // when list2 value is less than, copy it
                    curr.next = list2;
                    curr = curr.next;
                    list2 = list2.next;
                }
                else {
                    // if equal, copy both
                    curr.next = list1;
                    curr = curr.next;
                    list1 = list1.next;
                    curr.next = list2;
                    curr = curr.next;
                    list2 = list2.next;

                }
            }
        }

        return dummy.next; // return merged list
    }

    public static void main(String[] args) {

        System.out.println("21. Merged Two Sorted Lists\n");

        // example 1
        int[] a1 = {1, 2, 4};
        ListNode l1 = buildList(a1);
        int[] a2 = {1, 3, 4};
        ListNode l2 = buildList(a2);
        System.out.print(Arrays.toString(a1) + " + " + Arrays.toString(a2) + "\n= ");
        printList(mergeTwoLists(l1, l2));

        // example 2
        int[] b1 = {};
        l1 = buildList(b1);
        int[] b2 = {};
        l2 = buildList(b2);
        System.out.print(Arrays.toString(b1) + " + " + Arrays.toString(b2) + "\n= ");
        printList(mergeTwoLists(l1, l2));

    }

    public static ListNode buildList(int[] array) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int num : array) {

            curr.next = new ListNode(num);
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void printList(ListNode head) {

        System.out.print("[");

        while(head != null) {

            System.out.print(head.val);

            if(head.next != null) System.out.print(", ");

            head = head.next;
        }

        System.out.print("]\n\n");
    }
}
