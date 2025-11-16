 /**
     * Returns the minimum integer K (bananas per hour) such that Koko can eat all piles within H hours.
     *
     * Approach: Binary search on K.
     * - Lower bound = 1
     * - Upper bound = max pile size
     * For each candidate K check if sum(ceil(pile / K)) <= H.
     *
     * Time: O(n * log(maxPile))
     * Space: O(1)
     */


public class PROBLEM_875 {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);

        int lo = 1, hi = max;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(piles, H, mid)) {
                hi = mid; // can finish with mid, try smaller
            } else {
                lo = mid + 1; // cannot finish, need larger speed
            }
        }
        return lo;
    }

    // Helper: returns true if Koko can finish all piles within H hours at speed K.
    private boolean canFinish(int[] piles, int H, int K) {
        long hours = 0; // use long to be safe for large H or many piles
        for (int p : piles) {
            // ceil division: (p + K - 1) / K
            hours += (p + K - 1L) / K;
            if (hours > H) return false; // early exit
        }
        return hours <= H;
    }

    // Example test in main
    public static void main(String[] args) {
        PROBLEM_875 solver = new PROBLEM_875();

        // Example 1 from LeetCode:
        int[] piles1 = {3, 6, 7, 11};
        int H1 = 8;
        System.out.println("Expected 4, got: " + solver.minEatingSpeed(piles1, H1));

        // Additional tests
        int[] piles2 = {30, 11, 23, 4, 20};
        int H2 = 6;
        System.out.println("Expected 30, got: " + solver.minEatingSpeed(piles2, H2));

        int[] piles3 = {30, 11, 23, 4, 20};
        int H3 = 10;
        System.out.println("Expected 23, got: " + solver.minEatingSpeed(piles3, H3));
    }
}
