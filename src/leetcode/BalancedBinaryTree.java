package leetcode;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

    public int checkHeight(TreeNode node) {
        if(node == null) {
            return -1;
        }

        int leftHeight = checkHeight(node.left);
        if(leftHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int rightHeight = checkHeight(node.right);
        if(rightHeight == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        int diff = Math.abs(leftHeight - rightHeight);
        if(diff > 1) {
            return Integer.MIN_VALUE;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
