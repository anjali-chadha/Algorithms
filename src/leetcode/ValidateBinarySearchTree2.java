package leetcode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree2 {
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> inorder = new ArrayList<>();
        getInorderPattern(root, inorder);
        return isSorted(inorder);
    }

    private List<Integer> getInorderPattern(TreeNode node, List<Integer> list) {
        if(node == null) return list;

        getInorderPattern(node.left, list);
        list.add(node.val);
        getInorderPattern(node.right, list);
        return list;
    }

    private boolean isSorted(List<Integer> list) {
        int[] arr = list.stream().mapToInt(Integer :: intValue).toArray();
        for(int i = 0; i < arr.length - 1; i++ ) {
            if(arr[i] >= arr[i+1]) return false;
        }
        return true;
    }
}
