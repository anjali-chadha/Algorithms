package leetcode;

public class LCABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == root || q == root) return root;

        TreeNode lcaL = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaR = lowestCommonAncestor(root.right, p, q);
        if(lcaL != null && lcaR != null) return root;
        return lcaL == null ? lcaR: lcaL;

    }
}
