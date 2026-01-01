import java.util.*;

public class PROBLEM_721 {

    // Disjoint Set (Union-Find)
    static class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px != py)
                parent[py] = px;
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, Integer> emailIndex = new HashMap<>();
        Map<String, String> emailName = new HashMap<>();
        int index = 0;

        // Assign index to each email
         // Assign index to each email
        for (List<String> acc : accounts) {
            String name = acc.get(0);
            for (int i = 1; i < acc.size(); i++) {
                String email = acc.get(i);
                if (!emailIndex.containsKey(email)) {
                    emailIndex.put(email, index++);
                    emailName.put(email, name);
                }
            }
        }

        DSU dsu = new DSU(index);

        // Union emails in same account
        for (List<String> acc : accounts) {
            int firstEmailIndex = emailIndex.get(acc.get(1));
            for (int i = 2; i < acc.size(); i++) {
                dsu.union(firstEmailIndex, emailIndex.get(acc.get(i)));
            }
        }

        // Group emails by parent
        Map<Integer, TreeSet<String>> merged = new HashMap<>();
        for (String email : emailIndex.keySet()) {
            int root = dsu.find(emailIndex.get(email));
            merged.computeIfAbsent(root, k -> new TreeSet<>()).add(email);
        }

        // Build result
        List<List<String>> result = new ArrayList<>();
        for (TreeSet<String> emails : merged.values()) {
            List<String> list = new ArrayList<>();
            list.add(emailName.get(emails.first()));
            list.addAll(emails);
            result.add(list);
        }

        return result;
    }

    // MAIN METHOD WITH USER INPUT
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        List<List<String>> accounts = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            List<String> acc = new ArrayList<>();
            for (String p : parts) acc.add(p);
            accounts.add(acc);
        }

        List<List<String>> mergedAccounts = accountsMerge(accounts);

        // Print output
        for (List<String> acc : mergedAccounts) {
            System.out.println(acc);
        }

        sc.close();
    }
}
