package leetcode;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }
}
