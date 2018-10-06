package leetcode;

import java.util.Stack;

public class SymmetricTreeIterative {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
        public boolean isSymmetric(TreeNode root) {
            if(root == null) {
                return true;
            }

            return isSymmetric(root.left, root.right);
        }

        private boolean isSymmetric(TreeNode n1, TreeNode n2) {
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();

            stack1.push(n1);
            stack2.push(n2);

            while(!stack1.isEmpty() && !stack2.isEmpty()) {
                TreeNode n11 = stack1.pop();
                TreeNode n22 = stack2.pop();
                if(n11 == null && n22 == null) {
                    continue;
                } else if (n11 == null || n22 == null) {
                    return false;
                }

                if(n11.val != n22.val) {
                    return false;
                }
                stack1.push(n11.left);
                stack2.push(n22.right);

                stack1.push(n11.right);
                stack2.push(n22.left);

            }

            if(stack1.isEmpty() && stack2.isEmpty()) {
                return true;
            }
            return false;
        }


        public static void main(String[] args) {
            TreeNode root = new TreeNode (1);
            TreeNode n1 = new TreeNode(3);
            TreeNode n2 = new TreeNode(3);
            TreeNode n3 = new TreeNode(4);
            TreeNode n4 = new TreeNode(5);
            TreeNode n5 = new TreeNode(5);

            root.left = n1;
            root.right = n2;
            n1.left = n3;
            n1.right = n4;
            n2.left = n5;

            SymmetricTreeIterative o = new SymmetricTreeIterative();
            o.isSymmetric(root);
        }
        private static class TreeNode {
            int val;
            TreeNode right;
            TreeNode left;
            TreeNode(int val) {
                this.val = val;
            }

            @Override
            public String toString() {
                return this.val+ "";
            }
        }
}
