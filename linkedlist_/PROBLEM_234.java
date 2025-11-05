/*
 * LeetCode 234 - Palindrome Linked List
 * ✅ Checks whether a singly linked list is a palindrome.
 * ✅ Time Complexity = O(n), Space Complexity = O(1)
 * ✅ Uses fast & slow pointers + reversing second half of the list.
 * ✅ Class name as requested: PROBLEM_234
 */

public class PROBLEM_234 {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) {
            this.val = val;
        }
    }

    // Main function to check if list is a palindrome
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find middle of the linked list (slow will be at mid)
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode secondHalf = reverse(slow);

        // Step 3: Compare first and second half nodes
        ListNode firstHalf = head;
        ListNode secondHalfCopy = secondHalf; // To restore list later if needed

        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // ✅ Test the code (You can run this main method)
    public static void main(String[] args) {
        PROBLEM_234 obj = new PROBLEM_234();

        // Creating a list: 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(obj.isPalindrome(head) ? "Palindrome" : "Not Palindrome");
    }
}
