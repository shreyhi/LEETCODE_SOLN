/*
LeetCode Problem 11: Container With Most Water

Problem:
You are given an integer array height of length n. 
There are n vertical lines drawn such that the two endpoints of the i-th line are (i, 0) and (i, height[i]).
Find two lines that together with the x-axis form a container that holds the most water.

Approach:
We use the two-pointer technique:
- Start with two pointers, one at the beginning (l) and one at the end (r).
- Calculate the area between these two lines.
- Move the pointer with the smaller height inward (since the height limits the area).
- Continue until the two pointers meet.

Time Complexity: O(n)
Space Complexity: O(1)
*/

public class PROGRAM_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println("Maximum water container area: " + maxArea(height));
    }
    public static int maxArea(int[] height) {
        int l = 0;                     
        int r = height.length - 1;     
        int maxArea = 0;               
        while (l < r) {
            int width = r - l;
            int h = Math.min(height[l], height[r]);
            int area = width * h;
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++; 
            } else {
                r--; 
            }
        }

        return maxArea; 
    }
}
