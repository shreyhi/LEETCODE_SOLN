/**
     * Returns the area of the largest rectangle in the histogram.
     * Monotonic increasing stack of indices. We append a zero-height bar (by virtual index n)
     * to flush remaining bars from the stack at the end.
     *
     * Time: O(n), Space: O(n)
     *
     * heights array of non-negative integers representing the histogram bar heights
     *  maximum rectangular area
     */
import java.util.ArrayDeque;
import java.util.Deque;

public class PROBLEM_84 {

    
    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> stack = new ArrayDeque<>(); // store indices of bars, increasing heights
        int maxArea = 0;

        // iterate through all bars and one extra iteration with height 0 to flush stack
        for (int i = 0; i <= n; i++) {
            int currHeight = (i == n) ? 0 : heights[i];

            // while current bar is lower than the bar at stack top, compute area
            while (!stack.isEmpty() && currHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int leftIndex = stack.isEmpty() ? -1 : stack.peek();
                int width = i - leftIndex - 1;
                int area = h * width;
                if (area > maxArea) maxArea = area;
            }

            stack.push(i);
        }

        return maxArea;
    }

    // Simple main for quick local testing
    public static void main(String[] args) {
        int[] example1 = {2, 1, 5, 6, 2, 3}; // expected 10 (rectangle covering heights 5 and 6)
        int[] example2 = {2, 4};            // expected 4 (2 bars of height 2 => area 4 or single bar 4)
        int[] example3 = {};                // expected 0
        int[] example4 = {1};               // expected 1

        System.out.println("example1 -> " + largestRectangleArea(example1)); // 10
        System.out.println("example2 -> " + largestRectangleArea(example2)); // 4
        System.out.println("example3 -> " + largestRectangleArea(example3)); // 0
        System.out.println("example4 -> " + largestRectangleArea(example4)); // 1
    }
}
