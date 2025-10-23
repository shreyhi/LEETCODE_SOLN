import java.util.*;

public class PROBLEM_60 {

    public String getPermutationMath(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        k--;
        StringBuilder sb = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int idx = k / factorial[i - 1];
            sb.append(numbers.get(idx));
            numbers.remove(idx);
            k %= factorial[i - 1];
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        PROBLEM_60 solver = new PROBLEM_60();
        int n = 3, k = 4;
        System.out.println("Using Math Method: " + solver.getPermutationMath(n, k));
    }
}
