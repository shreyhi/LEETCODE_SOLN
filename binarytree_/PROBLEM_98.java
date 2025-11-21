public class PROBLEM_98 {
    
    // TreeNode class (same as LeetCode)
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

    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // validate node inside the range (min, max)
    private boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;

        // check BST property
        if (node.val <= min || node.val >= max) return false;

        // must satisfy both left and right subtrees
        return validate(node.left, min, node.val)
                && validate(node.right, node.val, max);
    }

    // Sample main to test
    public static void main(String[] args) {
        PROBLEM_98 obj = new PROBLEM_98();

        
        TreeNode root1 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println("Valid BST? " + obj.isValidBST(root1)); // true

        
        TreeNode root2 = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6))
        );
        System.out.println("Valid BST? " + obj.isValidBST(root2)); // false
    }
}
