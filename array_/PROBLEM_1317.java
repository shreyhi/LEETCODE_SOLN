/*
Problem 1317: Sum of Two No-Zero Integers

Description:
Find two positive integers a and b such that a + b = n and neither contains the digit 0.

Approach:
- Loop i from 1 to n-1.
- Check if both i and (n - i) have no zero digits.
- Return the first valid pair.

Time Complexity: O(n * log(n))
Space Complexity: O(1)
*/
class PROBLEM_1317 {

    public int[] getNoZeroIntegers(int n) {
        return findPair(n, 1);
    }

    private int[] findPair(int n, int a) {
        int b = n - a;
        if (isNoZero(a) && isNoZero(b)) {
            return new int[]{a, b};
        }
        return findPair(n, a + 1); // recursive instead of loop
    }

    private boolean isNoZero(int num) {
        while (num > 0) {
            if (num % 10 == 0) return false;
            num /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        PROBLEM_1317 sol = new PROBLEM_1317();
        int[] ans = sol.getNoZeroIntegers(1010);
        System.out.println(ans[0] + " + " + ans[1] + " = " + (ans[0] + ans[1]));
    }
}
