/*
 * We can use two hash maps (or arrays) to store mappings in both directions:

Map from s → t

Map from t → s

While iterating through the strings:

If a mapping already exists, verify it matches the current character.

If no mapping exists, create a new one.

If all checks pass, the strings are isomorphic.
Time Complexity: O(n) — one pass through both strings.

Space Complexity: O(1)

*/
import java.util.*;

public class PROBLEM_205 {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapS[c1] != mapT[c2]) return false;

            // store the index + 1 to mark mapping
            mapS[c1] = i + 1;
            mapT[c2] = i + 1;
        }
        return true;
    }

    // main method to test the function
    public static void main(String[] args) {
        String s1 = "egg", t1 = "add";
        String s2 = "foo", t2 = "bar";
        String s3 = "paper", t3 = "title";

        System.out.println(s1 + " & " + t1 + " → " + isIsomorphic(s1, t1));  // true
        System.out.println(s2 + " & " + t2 + " → " + isIsomorphic(s2, t2));  // false
        System.out.println(s3 + " & " + t3 + " → " + isIsomorphic(s3, t3));  // true
    }
}
