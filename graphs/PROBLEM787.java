
import java.util.*;

public class PROBLEM787 {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // Build adjacency list
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] f : flights) {
            graph.computeIfAbsent(f[0], x -> new ArrayList<>())
                 .add(new int[]{f[1], f[2]});
        }

        // Min-heap: {cost, city, stops}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int city = curr[1];
            int stops = curr[2];

            if (city == dst) {
                return cost;
            }

            if (stops > K) continue;

            if (!graph.containsKey(city)) continue;

            for (int[] next : graph.get(city)) {
                pq.offer(new int[]{
                        cost + next[1],
                        next[0],
                        stops + 1
                });
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of cities
        int n = sc.nextInt();

        // Number of flights
        int m = sc.nextInt();

        int[][] flights = new int[m][3];
        for (int i = 0; i < m; i++) {
            flights[i][0] = sc.nextInt(); // from
            flights[i][1] = sc.nextInt(); // to
            flights[i][2] = sc.nextInt(); // price
        }

        int src = sc.nextInt();
        int dst = sc.nextInt();
        int k = sc.nextInt();

        int result = findCheapestPrice(n, flights, src, dst, k);

        System.out.println("Cheapest Price: " + result);

        sc.close();
    }
}
