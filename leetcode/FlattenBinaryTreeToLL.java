//https://leetcode.com/problems/flatten-binary-tree-to-linked-list
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        root.left = null;
        flatten(left);
        flatten(right);
        root.right = left;
        TreeNode curr = root;
        while(curr.right != null) curr = curr.right;
        curr.right = right;
    }
    
    
}
