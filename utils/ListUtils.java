package utils;

public class ListUtils {

    // private constructor prevents instantiation
    private ListUtils() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated.");
    }

    public static ListNode buildList(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        for (int val : arr) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }

        return dummy.next;
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
}
