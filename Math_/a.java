public package Math_;

public class PROBLEM_29 {

    public static int divide(int dividend, int divisor) {
        // Handle overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine if the result should be negative
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and take absolute values to avoid overflow
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);

        int result = 0;

        // Subtract divisor multiples from dividend
        while (ldividend >= ldivisor) {
            long temp = ldivisor;
            long multiple = 1;

            // Double temp and multiple until it exceeds dividend
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            // Subtract the found multiple from dividend
            ldividend -= temp;
            result += multiple;
        }

        // Apply sign
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(divide(10, 3));      // Output: 3
        System.out.println(divide(7, -3));      // Output: -2
        System.out.println(divide(-15, 2));     // Output: -7
        System.out.println(divide(-20, -4));    // Output: 5
        System.out.println(divide(Integer.MIN_VALUE, -1)); // Output: 2147483647 (overflow case)
    }
}
 a {
    
}
