// LeetCode 104: Max Depth of Binary Tree (with user input)

import java.util.*;

public class PROBLEM_104 {

    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int v) { val = v; }
    }

    static TreeNode buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("null")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int i = 1;
        while (!q.isEmpty() && i < arr.length) {
            TreeNode cur = q.poll();
            if (!arr[i].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.left);
            }
            i++;
            if (i < arr.length && !arr[i].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(arr[i]));
                q.add(cur.right);
            }
            i++;
        }
        return root;
    }

    static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter nodes (level order), use null if no node:");
        String[] input = sc.nextLine().split("\\s+");
        TreeNode root = buildTree(input);
        System.out.println("Max Depth: " + maxDepth(root));
        sc.close();
    }
}
