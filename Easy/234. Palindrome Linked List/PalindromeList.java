import java.util.Arrays;

public class PalindromeList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode curr = head; // move pointer

        ListNode half = head; // head of the 2nd half of the list

        // 1 node behind half, head of the reversed 1st half of the list
        ListNode prev = new ListNode(head.val);
        // In case there's only 1 node, initial value of prev would be used
        // to compare it to half which would be at the head (will return true).

        int n = 0; // length of the list

        while(curr != null) { // traverse every node

            curr = curr.next; // move pointer to next node

            n++; // add 1 to length

            if(n % 2 == 0) { // add 1 node to be reversed every 2 node traversed

                ListNode next = half.next;
                // when you changed the direction of half to the left, the right nodes
                // will be forgotten unless you set a node forward to the left first
                half.next = prev;
                // carefully move prev since half has a hold of the left nodes now
                prev = half;
                // carefully move half since prev has a hold of the left nodes now
                half = next;
            }
        }

        // if list has an odd length, move half 1 node forward to equal to the length of 1st half
        if(n > 1 && n % 2 == 1) half = half.next;

        while(half != null) { // compare the 1st half (in reversed) to the 2nd half

            if(half.val != prev.val) return false;
            half = half.next;
            prev = prev.next;
        }

        return true; // 2nd half equals to the 1st half
    }

    public static void main(String[] args) {

        System.out.println("234. Palindrome Linked List");

        // example 1
        int[] a1 = {1};
        ListNode l1 = buildList(a1);
        System.out.println("\nLinked List: " + Arrays.toString(a1));
        System.out.println("Is Palidrome? " + isPalindrome(l1));

        // example 2
        int[] a2 = {1, 2, 1, 3, 1};
        ListNode l2 = buildList(a2);
        System.out.println("\nLinked List: " + Arrays.toString(a2));
        System.out.println("Is Palidrome? " + isPalindrome(l2));
    }

    // accepts int array, returns the head of the equivalent list
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
