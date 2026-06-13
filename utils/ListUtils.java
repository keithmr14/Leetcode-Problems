package utils;

public class ListUtils {

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

    public static ListNode[] buildArrayOfList(int[][] arr) {

        ListNode[] listArr = new ListNode[arr.length];

        for (int i = 0; i < arr.length; i++) {

            ListNode dummy = new ListNode();
            ListNode curr = dummy;

            for(int j = 0; j < arr[i].length; j++) {

                curr.next = new ListNode(arr[i][j]);
                curr = curr.next;
            }

            listArr[i] = dummy.next;
        }
        return listArr;
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
