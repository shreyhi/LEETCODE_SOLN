/**
 *   Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *   (Preorder = Root → Left → Right)
 *   Use an iterative method with a stack:
 *     1. Push the root node to a stack.
 *     2. Pop a node, add its value to the result list.
 *     3. Push its right child first, then left child (so left is processed first).
 * Time Complexity: O(n) — each node is visited once.
 * Space Complexity: O(n) — worst case for the stack (skewed tree).
 */
import java.util.*;
public class PROGRAM_144 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);

        while (!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);              // Visit root
            if (node.right != null) st.push(node.right); // Push right child
            if (node.left != null) st.push(node.left);   // Push left child
        }
        return res;
    }

    // Example test
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(new PROGRAM_144().preorderTraversal(root)); // Output: [1, 2, 3]
    }
}
