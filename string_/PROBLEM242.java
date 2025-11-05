/*Check if s.length() != t.length() → return false

Create int[] count = new int[26]

For each character c in s → count[c - 'a']++

For each character c in t → count[c - 'a']--

For each value n in count

If n != 0 → return false

Return true
Time Complexity: O(n) → just one pass through each string.

Space Complexity: O(1) → array size is always 26 (constant).*/
import java.util.*;
public class PROBLEM242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            count[c - 'a']--;
        }
        for (int n : count) {
            if (n != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        // Test cases
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1)); 

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); 

        String s3 = "listen";
        String t3 = "silent";
        System.out.println(isAnagram(s3, t3)); 
    }
}
