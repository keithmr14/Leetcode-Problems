package easy;

import utils.ListNode;
import static utils.ListUtils.*;
import java.util.Arrays;

public class PalindromeList {

    public static boolean isPalindrome(ListNode head) {

        ListNode curr = head;
        ListNode secondHalf = head;
        ListNode firstHalf = new ListNode(head.val);
        /* In case there's only one node, initial value of firstHalf would be
           used to compare it to half which would be at the head. */
        int n = 0;

        while(curr != null) {

            curr = curr.next;
            n++;

            if(n % 2 == 0) { // reverse 1 node every 2 node traversed

                ListNode next = secondHalf.next;
                secondHalf.next = firstHalf;
                firstHalf = secondHalf;
                secondHalf = next;
            }
        }

        if(n > 1 && n % 2 == 1) secondHalf = secondHalf.next;

        while(secondHalf != null) { // compare the 1st half (in reversed) to the 2nd half

            if(secondHalf.val != firstHalf.val) return false;
            secondHalf = secondHalf.next;
            firstHalf = firstHalf.next;
        }

        return true; // 2nd half equals to the 1st half
    }

    public static void main(String[] args) {

        System.out.println("234. Palindrome Linked List");

        // example 1
        int[] a1 = {1};
        ListNode l1 = buildList(a1);
        System.out.println("\nLinked List: " + Arrays.toString(a1));
        System.out.println("Is Palindrome? " + isPalindrome(l1));

        // example 2
        int[] a2 = {1, 2, 1, 3, 1};
        ListNode l2 = buildList(a2);
        System.out.println("\nLinked List: " + Arrays.toString(a2));
        System.out.println("Is Palindrome? " + isPalindrome(l2));
    }
}
