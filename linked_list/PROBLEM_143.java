import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PROBLEM_143 {

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. Middle of list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Reverse second half
        ListNode second = slow.next;
        slow.next = null;
        second = reverse(second);

        // 3. Merge two halves
        ListNode first = head;
        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }

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

    // Utility: build list
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int x : arr) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

    // Utility: print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + (head.next != null ? " -> " : ""));
            head = head.next;
        }
        System.out.println();
    }

    // MAIN with input
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter list values:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        ListNode head = buildList(arr);

        PROBLEM_143 solver = new PROBLEM_143();

        System.out.println("Original List:");
        printList(head);

        solver.reorderList(head);

        System.out.println("Reordered List:");
        printList(head);

        sc.close();
    }
}
