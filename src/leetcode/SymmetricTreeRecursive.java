package leetcode;

public class SymmetricTreeRecursive {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        } else if(n1 == null || n2 == null) {
            return false;
        }
        return (n1.val == n2.val) && isSymmetric(n1.left, n2.right)
                && isSymmetric(n1.right, n2.left);
    }

    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }
}
