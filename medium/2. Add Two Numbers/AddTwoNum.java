import java.util.Arrays;

public class AddTwoNum {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0); // -1 node
        ListNode curr = dummy; // move pointer

        int sum = l1.val + l2.val; // given that l1 and l2 aren't null and carry = 0
        int rem = sum % 10; // ones place of sum
        int carry = sum / 10; // tenth place of sum, will use in the next operation

        curr.next = new ListNode(rem); // add to the results
        curr = curr.next; // move pointer for the next result

        // while either the next digit of l1 and l2 aren't null or carry exist, create result
        while(l1.next != null || l2.next != null || carry > 0) {

            if(l1.next == null) l1.next = new ListNode(0); // avoid null when carrying operations
            l1 = l1.next; // move to pointer to the next digit of l1

            if(l2.next == null) l2.next = new ListNode(0); // avoid null when carrying operations
            l2 = l2.next; // move to pointer to the next digit of l2

            sum = l1.val + l2.val + carry; // consider that carry might exist
            rem = sum % 10; // ones place of sum
            carry = sum / 10; // tenth place of sum, will use in the next operation

            curr.next = new ListNode(rem); // add to the results
            curr = curr.next; // move pointer for the next result
        }

        return dummy.next; // return result nodes from the start
    }

    public static void main(String[] args) {

        System.out.println("2. Add Two Numbers\n");

        // example 1
        int[] a1 = {9, 1};
        int[] a2 = {1, 8};
        ListNode l1 = buildList(a1);
        ListNode l2 = buildList(a2);
        System.out.print(Arrays.toString(a1) + " + " + Arrays.toString(a2) + " = ");
        printList(addTwoNumbers(l1, l2));

        // example 2
        int[] b1 = {0};
        int[] b2 = {0};
        l1 = buildList(b1);
        l2 = buildList(b2);
        System.out.print(Arrays.toString(b1) + " + " + Arrays.toString(b2) + " = ");
        printList(addTwoNumbers(l1, l2));


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

    public static ListNode buildList(int[] array) {

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for(int elem : array) {

            curr.next = new ListNode(elem);
            curr = curr.next;
        }

        return dummy.next;
    }
}


