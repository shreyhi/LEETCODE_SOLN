 /**
     * Reverse bits of a 32-bit unsigned integer.
     * Example: input  43261596  (00000010100101000001111010011100)
     *          output 964176192 (00111001011110000010100101000000)
     *
     * Approach: iterate 32 times, build result by shifting left and appending n's LSB.
     *
     * Time: O(32) -> O(1)
     * Space: O(1)
     */
    public class PROBLEM_190 {

   
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // take LSB of n and append to result
            result = (result << 1) | (n & 1);
            // logical right shift n (fill with 0s)
            n = n >>> 1;
        }
        return result;
    }
    public static void main(String[] args) {
        PROBLEM_190 solver = new PROBLEM_190();

        // Example from LeetCode:
        int input = 43261596; // binary: 00000010100101000001111010011100
        int reversed = solver.reverseBits(input);

        System.out.println("Input (signed) : " + input);
        System.out.println("Input (binary) : " + String.format("%32s", Integer.toBinaryString(input)).replace(' ', '0'));
        System.out.println("Reversed (signed) : " + reversed);
        // To show the unsigned integer value (LeetCode expects unsigned interpretation)
        System.out.println("Reversed (unsigned) : " + Integer.toUnsignedLong(reversed));
        System.out.println("Reversed (binary): " + String.format("%32s", Integer.toBinaryString(reversed)).replace(' ', '0'));
    }
}
