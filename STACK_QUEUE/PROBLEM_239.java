import java.util.*;

public class PROBLEM_239 {

    /**
     * Returns the maximum of each sliding window of size k in nums.
     * Time: O(n), Space: O(k)
     */
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k <= 0) return new int[0];
        int n = nums.length;
        if (k == 1) return Arrays.copyOf(nums, n);

        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>(); // will store indices, values in decreasing order

        for (int i = 0; i < n; i++) {
            // Remove indices that are out of this window (i - k)
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // The first index at which we have a full window is i = k-1
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }

    // Simple main to demonstrate / test the function
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] res = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res)); // expected: [3, 3, 5, 5, 6, 7]

        // Additional test: edge cases
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{}, 3))); // []
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1}, 1))); // [1]
    }
}
