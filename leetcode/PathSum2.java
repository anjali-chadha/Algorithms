/**
https://leetcode.com/problems/path-sum-ii/submissions/
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        LinkedList<Integer> curr = new LinkedList<>();
        pathSum(root, sum, result, curr);
        return result;
    }
   
    private void pathSum(TreeNode node, int sum, List<List<Integer>> result, LinkedList<Integer> curr) {
        if(node == null) return;
        curr.add(node.val);

        if(node.left == null && node.right == null && node.val == sum) {
            result.add(new LinkedList(curr));
            curr.removeLast();
            return;
        }

        pathSum(node.left, sum - node.val, result, curr);
        pathSum(node.right, sum - node.val, result, curr);
        curr.removeLast();
    }
}
