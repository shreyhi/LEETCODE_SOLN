/* LeetCode 145 - Binary Tree Postorder Traversal (iterative + stack)
 * Initialize an empty stack and set curr = root, prev = null.

While the stack is not empty or curr is not null:
Go as far left as possible, pushing nodes onto the stack.
Peek the top node (node = stack.peek()).
If node.right is null or already visited (node.right == prev):
Visit node (add to result), pop it, and set prev = node.
Else, move to the right child (curr = node.right).
Continue until stack is empty.
The result list now contains nodes in postorder: Left → Right → Root.
 */
import java.util.*;

public class PROBLEM_145 {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Main function to perform postorder traversal
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null;
        TreeNode curr = root;

        while (!stack.isEmpty() || curr != null) {
            // Reach leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            TreeNode node = stack.peek();
            // If right child is null or already visited
            if (node.right == null || node.right == prev) {
                result.add(node.val);
                stack.pop();
                prev = node;
                curr = null;
            } else {
                curr = node.right;
            }
        }
        return result;
    }

    // Optional: Test the function
    public static void main(String[] args) {
        PROBLEM_145 sol = new PROBLEM_145();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(sol.postorderTraversal(root)); // Output: [3, 2, 1]
    }
}
