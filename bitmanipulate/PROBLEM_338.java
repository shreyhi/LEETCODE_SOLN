/**
 * LeetCode 338 - Counting Bits
 *
 * For a given integer n, return an array ans where:
 *   ans[i] = number of 1 bits in the binary representation of i
 * for all 0 <= i <= n.
 *
 * Idea (DP using i >> 1):
 *   - When we right shift i by 1 (i >> 1), we drop the last bit.
 *   - The number of set bits in i is:
 *       bits(i) = bits(i >> 1) + (i & 1)
 *   - (i & 1) gives 1 if the last bit is 1, else 0.
 *
 * Time:  O(n)
 * Space: O(n)
 */
public class PROBLEM_338 {

    // LeetCode function
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0; // 0 has no set bits

        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }

    // Optional: simple main to test locally
    public static void main(String[] args) {
        PROBLEM_338 solver = new PROBLEM_338();
        int n = 10;
        int[] result = solver.countBits(n);

        System.out.println("n = " + n);
        System.out.print("Bits count from 0 to " + n + " : ");
        for (int i = 0; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
