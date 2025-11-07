public class PROBLEM_124 {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private int maxSum = Integer.MIN_VALUE;

    // Main function to return maximum path sum
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    // Helper function to compute max gain from each node
    private int maxGain(TreeNode node) {
        if (node == null) return 0;

        // Get max sum from left and right subtrees; ignore negatives
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // Path sum passing through current node (as highest node)
        int newPathSum = node.val + leftGain + rightGain;

        // Update global maximum
        maxSum = Math.max(maxSum, newPathSum);

        // Return max gain for parent recursion (choose one path)
        return node.val + Math.max(leftGain, rightGain);
    }

    // Main function for testing
    public static void main(String[] args) {
        PROBLEM_124 solution = new PROBLEM_124();

        // Example Tree:
        //       -10
        //       /  \
        //      9   20
        //         /  \
        //        15   7

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        int result = solution.maxPathSum(root);
        System.out.println("Maximum Path Sum: " + result); // Output: 42
    }
}
