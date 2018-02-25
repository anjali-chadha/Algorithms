package leetcode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode node) {
        if (node == null) return null;

        TreeNode tmp = node.left;
        node.left = invertTree(node.right);
        node.right = invertTree(tmp);
        return node;
    }
}
