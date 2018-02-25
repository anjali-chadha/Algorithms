package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Preorder2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;

        while(true) {
            while(current != null) {
                result.add(current.val);
                stack.push(current);
                current = current.left;
            }

            if(!stack.isEmpty()) {
                TreeNode topElement = stack.pop();
                current = topElement.right;
            } else {
                break;
            }
        }
        return result;
    }
}
