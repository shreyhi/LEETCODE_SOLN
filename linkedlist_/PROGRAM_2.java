/*We simulate the addition the same way we do by hand.

Use a carry variable to store overflow digits.

Traverse both linked lists until all digits (and any remaining carry) are processed.

Use a dummy head node to easily return the final list.

Time Complexity: O(max(m, n))

Space Complexity: O(max(m, n)) (for the result list)*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class PROGRAM_2 {

    // Method to add two numbers represented by linked lists
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    // Helper method to print a linked list
    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }

    // Helper method to create a linked list from an array
    public static ListNode createList(int[] nums) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int num : nums) {
            curr.next = new ListNode(num);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Main method to test the program
    public static void main(String[] args) {
        // Example: (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // Which represents 342 + 465 = 807

        int[] num1 = {2, 4, 3};
        int[] num2 = {5, 6, 4};

        ListNode l1 = createList(num1);
        ListNode l2 = createList(num2);

        System.out.print("Input List 1: ");
        printList(l1);
        System.out.print("Input List 2: ");
        printList(l2);

        ListNode result = addTwoNumbers(l1, l2);

        System.out.print("Output List : ");
        printList(result);
    }
}
