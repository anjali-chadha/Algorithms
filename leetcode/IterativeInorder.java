package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result =  new ArrayList<>();
        if(root == null) return result;

        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;

        while(true) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }

            if(!stack.isEmpty()) {
                TreeNode topNode = stack.pop();
                result.add(topNode.val);
                current = topNode.right;
            } else{
                break;
            }
        }
        return result;
    }
}
