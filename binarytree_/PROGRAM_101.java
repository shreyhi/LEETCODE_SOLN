/*
LeetCode 101 – Symmetric Tree.
Given a binary tree, check if it is a mirror of itself (left/right are mirror images).
This standalone program reads a level-order array like: [1,2,2,3,4,4,3] (use 'null' for empty nodes),
builds the tree, and prints true/false.
*/

import java.io.*;
import java.util.*;

public class PROGRAM_101 {

    // --- Tree node definition ---
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    public static void main(String[] args) throws Exception {
        // Read entire stdin as a single line
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        if (line == null || line.trim().isEmpty()) {
            // Empty input -> empty tree -> symmetric by definition
            System.out.println("true");
            return;
        }

        TreeNode root = buildTreeFromLevelOrder(line.trim());
        boolean ans = isSymmetric(root);
        System.out.println(ans ? "true" : "false");
    }

    // Core solution (iterative BFS using a queue of node pairs)
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode[]> dq = new ArrayDeque<>();
        dq.add(new TreeNode[]{root.left, root.right});

        while (!dq.isEmpty()) {
            TreeNode[] pair = dq.poll();
            TreeNode a = pair[0], b = pair[1];

            if (a == null && b == null) continue;
            if (a == null || b == null) return false;
            if (a.val != b.val) return false;

            // Mirror children enqueue order: (a.left with b.right) and (a.right with b.left)
            dq.add(new TreeNode[]{a.left, b.right});
            dq.add(new TreeNode[]{a.right, b.left});
        }
        return true;
    }

    // Optional recursive version (unused but handy)
    public static boolean isSymmetricRecursive(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }
    private static boolean isMirror(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        return a.val == b.val
                && isMirror(a.left, b.right)
                && isMirror(a.right, b.left);
    }

    // --- Helper: build tree from level-order string like "[1,2,2,3,4,4,3]" or "1,2,2,null,3,3"
    private static TreeNode buildTreeFromLevelOrder(String s) {
        // Normalize: remove surrounding brackets
        s = s.trim();
        if (s.startsWith("[")) s = s.substring(1);
        if (s.endsWith("]")) s = s.substring(0, s.length() - 1);
        if (s.isEmpty()) return null;

        String[] parts = splitCSV(s);
        if (parts.length == 0) return null;

        // Parse first value as root
        Integer rootVal = parseNullableInt(parts[0]);
        if (rootVal == null) return null;
        TreeNode root = new TreeNode(rootVal);

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        int i = 1;

        while (!q.isEmpty() && i < parts.length) {
            TreeNode curr = q.poll();
            if (curr == null) continue;

            // Left child
            if (i < parts.length) {
                Integer v = parseNullableInt(parts[i++]);
                if (v != null) {
                    curr.left = new TreeNode(v);
                    q.add(curr.left);
                }
            }

            // Right child
            if (i < parts.length) {
                Integer v = parseNullableInt(parts[i++]);
                if (v != null) {
                    curr.right = new TreeNode(v);
                    q.add(curr.right);
                }
            }
        }
        return root;
    }

    // Robust CSV splitter: handles spaces and bare/null tokens
    private static String[] splitCSV(String s) {
        // Simple split by commas; trim each token
        String[] raw = s.split(",");
        for (int i = 0; i < raw.length; i++) raw[i] = raw[i].trim();
        return raw;
    }

    private static Integer parseNullableInt(String token) {
        if (token == null) return null;
        token = token.trim();
        if (token.equalsIgnoreCase("null") || token.isEmpty()) return null;
        // Allow tokens like "1" or " -2 "
        return Integer.parseInt(token);
    }
}
