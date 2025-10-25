/*We use a sliding window with a HashSet (or HashMap) to store characters in the current substring:

Move the right pointer (j) through the string.

If a duplicate character is found, move the left pointer (i) until duplicates are removed.

Keep track of the maximum window length seen so far.
Time Complexity: O(n) (each character visited at most twice)

Space Complexity: O(min(n, charset)) — O(26) for lowercase, or O(128) for ASCII*/
import java.util.*;

public class PROBLEM_3 {
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If duplicate character found, move left pointer
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println("Input: " + s);
        System.out.println("Longest substring length: " + lengthOfLongestSubstring(s));
    }
}
