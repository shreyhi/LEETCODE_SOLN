/*Use a min-heap (PriorityQueue) to keep track of the k largest elements.

Iterate through all numbers in nums.

Add each number to the heap using offer(num).

If heap size > k → remove (poll()) the smallest element.

After processing all numbers → heap contains k largest elements.

The smallest element in the heap (peek()) = kth largest overall.

Time: O(n log k)

Space: O(k)*/
import java.util.*;

public class PROBLEM_215 {

    public int findKthLargest(int[] nums, int k) {
        // Create a min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.offer(num);
            // Keep only k largest elements in the heap
            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Root of the heap = kth largest
        return pq.peek();
    }

    // For testing
    public static void main(String[] args) {
        PROBLEM_215 obj = new PROBLEM_215();
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println("Kth Largest Element: " + obj.findKthLargest(nums, k));
    }
}
