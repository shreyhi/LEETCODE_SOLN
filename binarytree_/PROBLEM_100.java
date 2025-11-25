import java.util.*;

// TreeNode structure (same as LeetCode)
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PROBLEM_100 {

    // Function: check if two trees are the same
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Build a tree from level-order input (using "null")
    public TreeNode buildTree(String[] nodes) {
        if (nodes.length == 0 || nodes[0].equals("null")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < nodes.length && !nodes[i].equals("null")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < nodes.length && !nodes[i].equals("null")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }

        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PROBLEM_100 obj = new PROBLEM_100();

        System.out.println("Enter Tree 1 (level order, use null for empty):");
        String[] t1 = sc.nextLine().trim().split("\\s+");

        System.out.println("Enter Tree 2 (level order, use null for empty):");
        String[] t2 = sc.nextLine().trim().split("\\s+");

        TreeNode root1 = obj.buildTree(t1);
        TreeNode root2 = obj.buildTree(t2);

        boolean result = obj.isSameTree(root1, root2);

        System.out.println("\nAre both trees same? " + result);
    }
}
