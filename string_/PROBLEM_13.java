import java.util.HashMap;
import java.util.Map;

public class PROBLEM_13 {

    public int romanToInt(String s) {
        // Step 1: Create a map for Roman numeral values
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Step 2: Initialize total
        int total = 0;

        // Step 3: Loop through the string
        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));

            // Step 4: Check for subtraction case
            if (i + 1 < s.length() && value < map.get(s.charAt(i + 1))) {
                total -= value;
            } else {
                total += value;
            }
        }

        return total;
    }

    // Optional: main method to test locally
    public static void main(String[] args) {
        PROBLEM_13 solution = new PROBLEM_13();

        String input1 = "III";
        String input2 = "LVIII";
        String input3 = "MCMXCIV";

        System.out.println(input1 + " -> " + solution.romanToInt(input1));  // Output: 3
        System.out.println(input2 + " -> " + solution.romanToInt(input2));  // Output: 58
        System.out.println(input3 + " -> " + solution.romanToInt(input3));  // Output: 1994
    }
}
