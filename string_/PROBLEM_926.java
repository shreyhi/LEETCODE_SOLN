
/*
 * LeetCode 921: Minimum Add to Make Parentheses Valid
 *
 * Problem summary:
 * You are given a string s consisting only of '(' and ')' characters.
 * A parentheses string is valid if:
 *   1. Every '(' has a matching ')' after it, and
 *   2. Parentheses are properly nested.
 *
 * Goal:
 *   Return the minimum number of parentheses that must be added (either '(' or ')')
 *   to make the input string a valid parentheses string.
 *
 * This program:
 *   - Takes the string s as USER INPUT from the console.
 *   - Computes the minimum number of additions required.
 *   - Prints the result.
 */

import java.util.Scanner;

public class PROBLEM_926 {

    // Function that solves LeetCode 921
    public static int minAddToMakeValid(String s) {
        int balance = 0;      // tracks number of unmatched '('
        int additions = 0;    // number of ')' or '(' we need to add

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // We have an opening bracket, it may be matched later
                balance++;
            } else if (ch == ')') {
                if (balance > 0) {
                    // We have a previous '(' available to match
                    balance--;
                } else {
                    // No '(' available to match this ')', so we need to add one '('
                    additions++;
                }
            }
            // If there are other characters, we simply ignore them
        }

        // After the loop:
        // 'balance' = number of unmatched '(' remaining.
        // We need to add exactly 'balance' ')' to match them.
        return additions + balance;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a parentheses string (only '(' and ')'): ");
        String s = sc.nextLine();

        int result = minAddToMakeValid(s);

        System.out.println("Minimum additions needed to make the string valid: " + result);

        sc.close();
    }
}
