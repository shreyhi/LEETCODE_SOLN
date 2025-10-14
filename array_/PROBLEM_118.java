 /*
  Goal: Generate first numRows of Pascal’s Triangle.

Pattern:

First and last elements = 1

Middle elements = sum of two numbers above (prev[j-1] + prev[j])

Approach:

Start with [1]

Build each row using the previous row

Store all rows in a list
Time: O(numRows²) — each row up to n elements.

Space: O(numRows²) — to store all rows.
 */
 import java.util.*;

public class PROBLEM_118 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        if (numRows == 0) return triangle;

        // First row
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);

        // Build each row
        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = new ArrayList<>();

            row.add(1); // first element

            // middle elements
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }

            row.add(1); // last element
            triangle.add(row);
        }

        return triangle;
    }

    // Main method for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int numRows = sc.nextInt();

        List<List<Integer>> result = generate(numRows);

        System.out.println("Pascal's Triangle:");
        for (List<Integer> row : result) {
            System.out.println(row);
        }

        sc.close();
    }
}
