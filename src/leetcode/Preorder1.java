package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Preorder1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<Integer>());
    }

    private List<Integer> preorderTraversal(TreeNode node, ArrayList<Integer> list) {
        if(node == null) return list;

        list.add(node.val);
        preorderTraversal(node.left, list);
        preorderTraversal(node.right, list);
        return list;
    }
}
