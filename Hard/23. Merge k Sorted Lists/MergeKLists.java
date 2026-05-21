import java.util.Arrays;

public class MergeKLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        ListNode dummy = new ListNode(0); // -1 print pointer
        ListNode curr = dummy; // move pointer

        // Given that any lists[i] is sorted in ascending order,
        // start with the list with the smallest head.
        int s = findSmallest(lists);

        // findSmallest returns -1 if no nodes are left
        while(s != -1) {
            // move pointer to the smallest head
            curr.next = lists[s];
            curr = curr.next;
            // check if next node is the same value
            while(curr.next != null) {

                ListNode next = curr.next;
                if(next.val == curr.val) curr = curr.next;
                else break; // terminate loop if not the same number
            }
            // skip nodes from head that's already merged
            lists[s] = curr.next;
            // check the next smallest node from the ListNode[] lists
            s = findSmallest(lists);
        }

        return dummy.next; // return nodes after print pointer
    }

    public static int findSmallest(ListNode[] lists) {

        int smallest = -1; // default out of bounds index

        for(int i = 0; i < lists.length; i++) { // for each list
            // if head is null, check next list
            if(lists[i] == null) continue;
            // if it's first head that isn't null, set as smallest
            if(smallest == -1) smallest = i;
            // else compare and set the smallest
            else if(lists[smallest].val > lists[i].val) smallest = i;
        }
        // I decided to return an int index instead of a ListNode
        // because it's more intuitive for me.
        return smallest;
    }

    public static void main(String[] args) {

        System.out.println("23. Merge k Sorted Lists");

        // example 1
        int[][] a1 = {{1, 4, 5}, {1, 3, 4}, {2, 6}};
        printArray(a1);
        printList(mergeKLists(buildList(a1)));

        // example 2
        int[][] a2 = {{}};
        printArray(a2);
        printList(mergeKLists(buildList(a2)));
    }

    public static void printArray(int[][] arrays) {

        System.out.print("\nk Sorted Lists: [");

        for(int i = 0; i < arrays.length; i++) {

            System.out.print(Arrays.toString(arrays[i]));
            if(i < arrays.length - 1) System.out.print(", ");
        }
        System.out.print("]\n");
    }

    public static void printList(ListNode head) {

        System.out.print("Merged List: [");

        while (head != null) {

            System.out.print(head.val);

            if (head.next != null) System.out.print(", ");

            head = head.next;
        }
        System.out.print("]\n");
    }

    public static ListNode[] buildList(int[][] arr) {

        ListNode[] listArr = new ListNode[arr.length];

        for (int i = 0; i < arr.length; i++) {

            ListNode dummy = new ListNode(0);
            ListNode curr = dummy;

            for(int j = 0; j < arr[i].length; j++) {

                curr.next = new ListNode(arr[i][j]);
                curr = curr.next;
            }

            listArr[i] = dummy.next;
        }
        return listArr;
    }
}
