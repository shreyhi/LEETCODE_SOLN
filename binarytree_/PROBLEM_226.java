// LeetCode 226 - Invert Binary Tree
// This program takes user input for a binary tree (level-order with "null")
// and outputs the inverted (mirrored) tree also in level-order.

import java.util.*;

// TreeNode structure (same as LeetCode)
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class PROBLEM_226 {

    // Function to invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert children
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // Build a tree from level-order input
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

    // Print level order of a tree
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                System.out.print("null ");
                continue;
            }

            System.out.print(node.val + " ");
            q.add(node.left);
            q.add(node.right);
        }

        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PROBLEM_226 obj = new PROBLEM_226();

        System.out.println("Enter Tree (level order, use null for empty):");
        String[] treeInput = sc.nextLine().trim().split("\\s+");

        TreeNode root = obj.buildTree(treeInput);

        System.out.println("\nOriginal Tree (level-order):");
        obj.printLevelOrder(root);

        TreeNode inverted = obj.invertTree(root);

        System.out.println("\nInverted Tree (level-order):");
        obj.printLevelOrder(inverted);
    }
}
 {
    
}
