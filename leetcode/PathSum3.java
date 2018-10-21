/**
https://leetcode.com/problems/binary-tree-paths/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        binaryTreePaths(root, result, "" + root.val);
        return result;
    }
    
    private void binaryTreePaths(TreeNode node, List<String> result, String curr) {
        if(node.right == null && node.left == null) {
            result.add(curr);
            return;
        } 
        if(node.left != null)
            binaryTreePaths(node.left, result, curr + "->" + node.left.val);
        if(node.right != null)
            binaryTreePaths(node.right, result, curr + "->" + node.right.val);
    }
}
