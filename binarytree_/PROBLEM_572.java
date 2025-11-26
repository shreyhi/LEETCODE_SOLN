/*
 Traverse the main tree (root)
At every node, we check if the subtree starting there matches subRoot.

Check if two trees are identical (isSameTree)
Two trees are identical if:

Their root values match

Their left subtrees match

Their right subtrees match
 */

import java.util.*;

public class PROBLEM_572 {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Core function: check if subRoot is a subtree of root
    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        // If trees match at this node, return true
        if (isSameTree(root, subRoot)) {
            return true;
        }
        // Otherwise, check left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper: check if two trees are identical
    private static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    // Build tree from level-order representation using "null" for empty nodes
    // Example: "3 4 5 1 2 null null" -> tree
    public static TreeNode buildTreeFromLevelOrder(String line) {
        line = line.trim();
        if (line.isEmpty()) {
            return null;
        }

        String[] parts = line.split("\\s+");
        if (parts.length == 0 || parts[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(parts[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < parts.length) {
            TreeNode current = queue.poll();

            // Left child
            if (i < parts.length && !parts[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(parts[i]));
                current.left = left;
                queue.offer(left);
            }
            i++;

            // Right child
            if (i < parts.length && !parts[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(parts[i]));
                current.right = right;
                queue.offer(right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read first tree (root)
        if (!sc.hasNextLine()) {
            System.out.println("false");
            sc.close();
            return;
        }
        String rootLine = sc.nextLine();

        // Read second tree (subRoot)
        if (!sc.hasNextLine()) {
            System.out.println("false");
            sc.close();
            return;
        }
        String subRootLine = sc.nextLine();

        sc.close();

        TreeNode root = buildTreeFromLevelOrder(rootLine);
        TreeNode subRoot = buildTreeFromLevelOrder(subRootLine);

        boolean ans = isSubtree(root, subRoot);
        System.out.println(ans ? "true" : "false");
    }
}
