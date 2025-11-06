import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PRO_455 {

    // Greedy: sort both arrays, then match the smallest possible cookie to each child
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0; // index for children (g)
        int j = 0; // index for cookies (s)
        int content = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // cookie j can satisfy child i
                content++;
                i++;
                j++;
            } else {
                j++; // try a bigger cookie
            }
        }
        return content;
    }

   
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String lineG = br.readLine();
        String lineS = br.readLine();

        // If no input is provided, run a quick demo
        if (lineG == null || lineG.trim().isEmpty() || lineS == null || lineS.trim().isEmpty()) {
            int[] demoG = {1, 2, 3};
            int[] demoS = {1, 1};
            System.out.println(findContentChildren(demoG, demoS)); // expected 1
            return;
        }

        int[] g = parseIntArray(lineG);
        int[] s = parseIntArray(lineS);

        System.out.println(findContentChildren(g, s));
    }

    private static int[] parseIntArray(String line) {
        // Supports space and/or comma separation, ignores extra spaces
        String[] tokens = line.trim().split("[,\\s]+");
        int[] arr = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }
        return arr;
    }
}
