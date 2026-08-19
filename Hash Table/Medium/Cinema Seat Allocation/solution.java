import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Integer> map = new HashMap<>();

        // Store reserved seats of each row using a bitmask
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.put(row,
                map.getOrDefault(row, 0) | (1 << col));
        }

        // Every row without reservations can fit 2 families
        int ans = (n - map.size()) * 2;

       int left = 0b0000111100;    // seats 2,3,4,5
int middle = 0b0011110000;  // seats 4,5,6,7
int right = 0b1111000000;   // seats 6,7,8,9

        for (int mask : map.values()) {

            boolean leftFree = (mask & left) == 0;
            boolean middleFree = (mask & middle) == 0;
            boolean rightFree = (mask & right) == 0;

            if (leftFree && rightFree) {
                ans += 2;
            } else if (leftFree || middleFree || rightFree) {
                ans += 1;
            }
        }

        return ans;
    }
}