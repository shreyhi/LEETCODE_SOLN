/*
Kadane’s Algorithm is a very famous method to find the maximum sum of a contiguous subarray (a subarray means consecutive elements).
As you move through the array:
Keep a running sum (currentSum) of the elements.
If currentSum ever becomes negative, it means this subarray is hurting our total — so we reset it to 0 (start a new subarray).
Always keep track of the largest sum (maxSum) you’ve seen so far.
*/
import java.util.Scanner;

public class PROBLEM_561 {

    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int maxSum = nums[0]; 

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (sum > maxSum) {
                maxSum = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxSubArray(nums);
        System.out.println("Maximum Subarray Sum = " + result);

        sc.close();
    }
}
