// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PROBLEM_148 {

    // ✅ Main function to sort the list
    public ListNode sortList(ListNode head) {
        // Base case: 0 or 1 element
        if (head == null || head.next == null) return head;

        // Step 1: Split list into two halves
        ListNode mid = getMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null; // break the list into two halves

        // Step 2: Sort each half
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // Step 3: Merge sorted halves
        return merge(left, right);
    }

    // ✅ Helper function to find middle of the list (fast & slow pointer)
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next; // move fast one ahead to split correctly
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // ✅ Helper function to merge two sorted lists
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // Append the remaining nodes
        if (l1 != null) tail.next = l1;
        if (l2 != null) tail.next = l2;

        return dummy.next;
    }

    // ✅ Example usage
    public static void main(String[] args) {
        PROGRAM_148 obj = new PROGRAM_148();

        // Create linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        // Sort list
        ListNode sorted = obj.sortList(head);

        // Print sorted list
        System.out.print("Sorted list: ");
        while (sorted != null) {
            System.out.print(sorted.val + " ");
            sorted = sorted.next;
        }
    }
}
