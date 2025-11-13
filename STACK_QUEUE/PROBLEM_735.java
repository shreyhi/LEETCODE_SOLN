import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;

public class PROBLEM_735 {

    /**
     * Solves LeetCode 735 - Asteroid Collision
     * @param asteroids input array of asteroids (positive = right, negative = left)
     * @return array of asteroids that remain after all collisions
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int a : asteroids) {
            boolean alive = true;

            // Only possible collision when current asteroid moves left (a < 0)
            // and stack top is moving right (> 0)
            while (alive && a < 0 && !stack.isEmpty() && stack.peekLast() > 0) {
                int top = stack.peekLast();
                if (top < -a) {
                    // top explodes; continue checking further collisions
                    stack.pollLast();
                    // keep alive true to compare with next top
                } else if (top == -a) {
                    // both explode
                    stack.pollLast();
                    alive = false;
                } else { // top > -a
                    // current asteroid explodes
                    alive = false;
                }
            }

            if (alive) {
                stack.addLast(a);
            }
        }

        // Convert deque to int[] in correct order (left to right)
        int[] result = new int[stack.size()];
        int idx = 0;
        for (int v : stack) result[idx++] = v;
        return result;
    }

    // Optional simple test harness
    public static void main(String[] args) {
        PROBLEM_735 solver = new PROBLEM_735();

        int[] input1 = {5, 10, -5};
        System.out.println(Arrays.toString(solver.asteroidCollision(input1))); // [5,10]

        int[] input2 = {8, -8};
        System.out.println(Arrays.toString(solver.asteroidCollision(input2))); // []

        int[] input3 = {10, 2, -5};
        System.out.println(Arrays.toString(solver.asteroidCollision(input3))); // [10]

        int[] input4 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(solver.asteroidCollision(input4))); // [-2, -1, 1, 2]
    }
}
