// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) { 
        this.val = val; 
    }
}

class PROBLEM_543 {

    // nstarting: diameter = longest path between any two nodes; compute height recursively
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // MAIN METHOD TO GIVE INPUT AND PRINT OUTPUT
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        PROBLEM_543 obj = new PROBLEM_543();
        int output = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter of the tree = " + output);
    }
}
