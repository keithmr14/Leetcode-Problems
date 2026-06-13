package medium;

import utils.ListNode;
import java.util.Arrays;

public class PartitionPivot {

    public static int[] pivotArray(int[] nums, int pivot) {

        ListNode dummy = new ListNode();
        // starts creating left of pivot and pivot at the start
        ListNode maxLowerRange = dummy;
        ListNode pivotEnd = new ListNode();
        boolean foundPivot = false;
        // starts creating right of pivot separately
        ListNode minHigherRange = null;
        ListNode lastNode = new ListNode();
        boolean foundHigher = false;

        for(int num : nums) {

            if(num == pivot) {

                ListNode next = maxLowerRange.next;
                ListNode addPivot = new ListNode(pivot);
                maxLowerRange.next = addPivot;
                addPivot.next = next;

                if(!foundPivot) {
                    pivotEnd = addPivot;
                    foundPivot = true;
                }
            }
            else if(num > pivot) {

                if(!foundHigher) {
                    minHigherRange = new ListNode(num);
                    lastNode = minHigherRange;
                    foundHigher = true;
                } else {
                    lastNode.next = new ListNode(num);
                    lastNode = lastNode.next;
                }
            }
            else { // num < pivot
                ListNode next = maxLowerRange.next;
                maxLowerRange.next = new ListNode(num);
                maxLowerRange = maxLowerRange.next;
                maxLowerRange.next = next;
            }
        }
        if(!foundPivot) maxLowerRange.next = minHigherRange;
        else pivotEnd.next = minHigherRange;

        for (int i = 0; dummy.next != null; i++) {
            nums[i] = dummy.next.val;
            dummy = dummy.next;
        }
        return nums;
    }

    public static void main(String[] args) {

        System.out.println("2161. Partition Array According to Given Pivot");

        // example 1
        int[] a1 = {9, 12, 5, 10, 14, 3, 10};
        int p1 = 10;
        System.out.println("\nArray: " + Arrays.toString(a1));
        System.out.println("Pivot: " + p1);
        System.out.println("Partition: " + Arrays.toString(pivotArray(a1, p1)));

        // example 2
        int[] a2 = {4, 0, 4, 5, -11};
        int p2 = 5;
        System.out.println("\nArray: " + Arrays.toString(a2));
        System.out.println("Pivot: " + p2);
        System.out.println("Partition: " + Arrays.toString(pivotArray(a2, p2)));

        // example 3
        int[] a3 = {};
        int p3 = -1;
        System.out.println("\nArray: " + Arrays.toString(a3));
        System.out.println("Pivot: " + p3);
        System.out.println("Partition: " + Arrays.toString(pivotArray(a3, p3)));
    }
}
