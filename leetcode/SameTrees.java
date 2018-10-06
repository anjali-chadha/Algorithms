package leetcode;

public class SameTrees {

        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) {
                return true;
            } else if (p == null || q == null) {
                return false;
            }

            return (p.val == q.val) && isSameTree(p.left, q.left)
                    && isSameTree(p.right, q.right);
        }

        class TreeNode {
            int val;
            TreeNode right;
            TreeNode left;
        }
}
