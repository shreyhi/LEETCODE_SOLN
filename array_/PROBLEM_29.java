/*
Use two pointers (i and j) to remove duplicates in-place in a sorted array.

i → tracks the position of the last unique element.

j → scans through the array.

Whenever nums[j] != nums[i],
move i forward and copy the new value:
nums[++i] = nums[j];

Finally, return i + 1 as the count of unique elements.
Time Complexity: O(n)
 Space Complexity: O(1)
*/
public class PROBLEM_29 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3};
        Solution solution = new Solution();
        int length = solution.removeDuplicates(nums);

        System.out.println("New length: " + length);
        System.out.print("Modified array: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
