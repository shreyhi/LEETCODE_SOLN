public class problem_58 {
    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;

        // Step 1: Skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // Step 2: Count the characters of the last word
        while (i >= 0 && s.charAt(i) != ' ') {
            length++;
            i--;
        }

        return length;
    }

    // Main method for testing
    public static void main(String[] args) {
        problem_58 solution = new problem_58();

        // Test cases
        String s1 = "Hello World";
        String s2 = "   fly me   to   the moon  ";
        String s3 = "luffy is still joyboy";
        String s4 = "singleword";
        String s5 = "   "; // edge case: only spaces

        System.out.println("Input: \"" + s1 + "\" → Output: " + solution.lengthOfLastWord(s1)); // 5
        System.out.println("Input: \"" + s2 + "\" → Output: " + solution.lengthOfLastWord(s2)); // 4
        System.out.println("Input: \"" + s3 + "\" → Output: " + solution.lengthOfLastWord(s3)); // 7
        System.out.println("Input: \"" + s4 + "\" → Output: " + solution.lengthOfLastWord(s4)); // 10
        System.out.println("Input: \"" + s5 + "\" → Output: " + solution.lengthOfLastWord(s5)); // 0
    }
}
