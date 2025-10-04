/*
 * To rotate an array right by k,
we can reverse the array in three steps:

Reverse the entire array.

Reverse the first k elements.

Reverse the remaining n - k elements.

 Example:

nums = [1, 2, 3, 4, 5, 6, 7], k = 3

1️ Reverse whole array → [7, 6, 5, 4, 3, 2, 1]
2️ Reverse first 3 → [5, 6, 7, 4, 3, 2, 1]
3️Reverse last 4 → [5, 6, 7, 1, 2, 3, 4] done!
 */
public class PROBLEM_189 {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}


