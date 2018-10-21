/**
https://leetcode.com/problems/path-sum/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {return false;}
        if(root.left == null && root.right == null) {
            if(root.val == sum) return true; 
            return false;
        }
        return  hasPathSum(root.left, sum - root.val) 
            ||hasPathSum(root.right, sum - root.val); 
    }
}
