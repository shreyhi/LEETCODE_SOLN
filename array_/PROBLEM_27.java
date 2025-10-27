/**
     * Removes all occurrences of val in nums in-place.
     * Returns the new length (elements before this index are the kept elements).
     * Time: O(n) — one pass over the array.

       Space: O(1) — in-place, constant extra space.
     */
    public class PROBLEM_27 {

    
    public static int removeElement(int[] nums, int val) {
        int k = 0; // slow pointer for position of next kept element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    // Simple test harness
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int newLen = removeElement(nums, val);

        System.out.println("New length: " + newLen);
        System.out.print("Modified array (first " + newLen + " elements): ");
        for (int i = 0; i < newLen; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
