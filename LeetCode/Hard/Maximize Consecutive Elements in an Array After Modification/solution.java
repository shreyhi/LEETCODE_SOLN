import java.util.Arrays;

class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        
        int maxVal = nums[nums.length - 1];
        // dp[v] stores the max length of a consecutive sequence ending at value v
        int[] dp = new int[maxVal + 2];
        int maxLen = 1;
        
        for (int x : nums) {
            // Update x + 1 first using the previous state of dp[x]
            dp[x + 1] = dp[x] + 1;
            // Then update x using dp[x - 1]
            dp[x] = dp[x - 1] + 1;
            
            maxLen = Math.max(maxLen, Math.max(dp[x], dp[x + 1]));
        }
        
        return maxLen;
    }
}