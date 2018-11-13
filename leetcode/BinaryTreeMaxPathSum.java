/*
Questions asked:
Tree empty
all nodes negative

Using bottom up approach. At each node, potential max path could be one of these cases:
1) Max(left tree) + node
2) Max(right tree) + node
3) Max( left) + node + Max( right)
4) node itself

O(N) - Time Complexity
*/

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
    
    private int maxSum;
    
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxSum = Integer.MIN_VALUE;
        maxDownSum(root);
        return maxSum;
    }
    
    private int maxDownSum(TreeNode node) {
        if(node == null) return 0;
        int leftSumMax = Math.max(0, maxDownSum(node.left));
        int rightSumMax = Math.max(0, maxDownSum(node.right));
        
        maxSum = Math.max(maxSum, node.val + leftSumMax + rightSumMax);
        return node.val + Math.max(leftSumMax, rightSumMax);
    }
}
