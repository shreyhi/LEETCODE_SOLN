/*Start from the root node.

Keep going left and push each node onto the stack.
→ This ensures we visit leftmost nodes first.

When there’s no more left child:

Pop a node from the stack.

Add its value to the result list.

Move to its right childs.

Repeat until both the current node is null and the stack is empty.*/
import java.util.*;
public class PROBLEM_94 {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // Reach the leftmost node of current node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            ans.add(curr.val);      // Visit the node
            curr = curr.right;      // Visit the right subtree
        }
        return ans;
    }

    // ✅ Helper function to create a sample tree and test
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result);  // Output: [1, 3, 2]
    }
}
