package leetcode;

public class InorderSuccessorBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p == null) return null;

        if(p.right != null) {
            return smallestElement(p.right);
        } else  {
            TreeNode parent = p.parent;
            while(parent != null && isRightChild(parent, p)) {
                p = parent;
                parent = p.parent;
            }
            if(parent == null) {
                return null;
            } else {
                return parent;
            }
        }
    }

    private TreeNode smallestElement(TreeNode node) {
        TreeNode current = node;
        if(current.left != null) {
            current = current.left;
        }
        return current;
    }

    private boolean isRightChild(TreeNode parent, TreeNode child) {
        return parent.right == child;
    }
}
