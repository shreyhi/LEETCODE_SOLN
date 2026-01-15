import java.util.*;

public class PROBLEM162 {

    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid + 1]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Edge case: no elements
        if (n == 0) {
            System.out.println("Array is empty. No peak element.");
            sc.close();
            return;
        }

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Edge case: only one element
        if (n == 1) {
            System.out.println("Peak element index: 0");
            System.out.println("Peak element value: " + nums[0]);
            sc.close();
            return;
        }

        int peakIndex = findPeakElement(nums);

        System.out.println("Peak element index: " + peakIndex);
        System.out.println("Peak element value: " + nums[peakIndex]);

        sc.close();
    }
}
