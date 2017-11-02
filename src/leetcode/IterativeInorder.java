package leetcode;

import java.util.Stack;

public class IterativeInorder {

    public void iterativeInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode n = stack.pop();
            stack.push(n.right);
            System.out.print(n.val + " ");
            stack.push(n.left);
        }
    }


    class TreeNode {
        int val;
        TreeNode right;
        TreeNode left;
    }
}
