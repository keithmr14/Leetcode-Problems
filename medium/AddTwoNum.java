package medium;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class AddTwoNum {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry > 0) {
            if(l1 == null) l1 = new ListNode(0);
            if(l2 == null) l2 = new ListNode(0);

            int sum = l1.val + l2.val + carry;
            int rem = sum % 10; // num at ones place
            curr.next = new ListNode(rem);
            carry = sum / 10; // num at tenth place

            l1 = l1.next;
            l2 = l2.next;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        System.out.println("2. Add Two Numbers");
        // example 1
        int[] a1 = {9, 1};
        int[] b1 = {1, 8};
        ListNode l1 = buildList(a1);
        ListNode l2 = buildList(b1);
        System.out.println("\nTwo Num: " + Arrays.toString(a1) + " + " + Arrays.toString(b1));
        System.out.print("Sum: ");
        printList(addTwoNumbers(l1, l2));
        // example 2
        int[] a2 = {0};
        int[] b2 = {0};
        l1 = buildList(a2);
        l2 = buildList(b2);
        System.out.println("\nTwo Num: " + Arrays.toString(a2) + " + " + Arrays.toString(b2));
        System.out.print("Sum: ");
        printList(addTwoNumbers(l1, l2));
    }
}
