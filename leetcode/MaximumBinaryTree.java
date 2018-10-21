/**
https://leetcode.com/problems/maximum-binary-tree/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int L, int R) {
        if(L > R) return null;
        if(L == R) return new TreeNode(nums[L]);
        
        int maxIdx = findMax(nums, L, R);
        TreeNode curr = new TreeNode(nums[maxIdx]);
        curr.left = helper(nums, L, maxIdx - 1);
        curr.right = helper(nums, maxIdx + 1, R);
        return curr;
    }
    
    private int findMax(int[] nums, int L, int R) {
        int maxVal = nums[L];
        int maxIdx = L;
        for(int i = L + 1; i <= R; i++) {
            if(nums[i] > maxVal) { maxVal = nums[i]; maxIdx = i;}
        }
        return maxIdx;
    }
}
