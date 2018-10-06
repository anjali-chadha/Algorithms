package leetcode;

public class MergeBST {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) return null;
        else if(t1 == null) return t2;
        else if(t2 == null)  return t1;
        else {
            t2.val += t1.val;
            t2.left = mergeTrees(t1.left, t2.left);
            t2.right = mergeTrees(t1.right, t2.right);
        }
        return t2;
    }
}
