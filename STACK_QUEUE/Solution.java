/**
 * LeetCode 496: Next Greater Element I
 * Given two arrays nums1 and nums2 where nums1 is a subset of nums2,
 * for each element in nums1 find the next greater element in nums2.
 *
 * Approach: Monotonic decreasing stack + HashMap to store next greater for elements of nums2.
 *
 * Time: O(n2 + n1) -> O(n2) where n2 = nums2.length, n1 = nums1.length
 * Space: O(n2) for map + stack
 */
import java.util.*;
public class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map from value in nums2 -> its next greater element (or absent if none)
        Map<Integer, Integer> nextGreater = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>(); // will store a decreasing sequence of values

        for (int num : nums2) {
            // If current number is greater than elements on stack, it's their next greater
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreater.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // Remaining elements in stack have no next greater -> implicitly -1 (not stored)
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; ++i) {
            res[i] = nextGreater.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    // Simple test harness
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1a = {4, 1, 2};
        int[] nums2a = {1, 3, 4, 2};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1a, nums2a)));
        // expected: [-1, 3, -1]

        int[] nums1b = {2, 4};
        int[] nums2b = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1b, nums2b)));
        // expected: [3, -1]
    }
}
