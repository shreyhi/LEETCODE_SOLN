/*Goal: Add two binary strings and return the sum as a binary string.

Idea: Simulate manual binary addition from right to left. Keep track of a carry.

Steps:

Start from the end of both strings.

Add corresponding bits + carry → append (sum % 2) to result.

Update carry → carry = sum / 2.

Continue until both strings are done and carry is 0.

Reverse the result string.

Complexity:

Time: O(max(m, n))

Space: O(max(m, n))*/
import java.util.Scanner;

public class PROBLEM_67{

    // Method to add two binary strings
    public static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {
            if (i >= 0) carry += a.charAt(i--) - '0';
            if (j >= 0) carry += b.charAt(j--) - '0';
            result.append(carry % 2);
            carry /= 2;
        }

        return result.reverse().toString();
    }

    // Main method to test the addBinary function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first binary string: ");
        String a = sc.nextLine();
        System.out.print("Enter second binary string: ");
        String b = sc.nextLine();

        String sum = addBinary(a, b);
        System.out.println("Sum of binary strings: " + sum);

        sc.close();
    }
}
