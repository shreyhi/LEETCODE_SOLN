/*A valid rotated sorted array can only have at most one break (where nums[i] > nums[i+1]).
If there are 0 breaks, it’s already sorted.
If there is 1 break, it’s a valid rotation.
If there are 2 or more breaks, it’s invalid.
Time Complexity: O(n)
 Space Complexity: O(1)*/
import java.util.Scanner;

public class PROBLEM_1752 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        Solution sol = new Solution();
        boolean result = sol.check(nums);

        System.out.println("Is the array sorted and rotated? " + result);

        sc.close();
    }
}

class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int countBreaks = 0;

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n; // circular check
            if (nums[i] > nums[next]) {
                countBreaks++;
            }
            if (countBreaks > 1) {
                return false; // more than one break → invalid
            }
        }
        return true; // 0 or 1 break is valid
    }
}

