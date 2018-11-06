/*
Approach 1 - Use BFS
Space Complexity - O(N) - Maximum number of nodes that can be present in a single level
Time Complexity - O(N) - Have to visit all the nodes atleast once 
because we are solving this question for a generic tree

Approach 2 - Use DFS
Time - O(N) 
Space Complexity - O(height of tree) - in worse case - O(N)
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
    public List<Integer> rightSideView_BFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        
        TreeNode dummy = null;
        int level = 0;
        Queue<TreeNode> bfsQ = new LinkedList<>();
        bfsQ.offer(root);
        bfsQ.offer(dummy);
        while(!bfsQ.isEmpty()) {
            TreeNode curr = bfsQ.poll();
            if(curr == null) {
                if(!bfsQ.isEmpty()) {
                    
                    bfsQ.offer(dummy);
                    level++;
                }
            } else {
                if(result.size() < level+1) result.add(curr.val);
                else result.set(level, curr.val);
                if(curr.left != null) bfsQ.offer(curr.left);
                if(curr.right != null) bfsQ.offer(curr.right);
            }
        }
        return result;
    }
    
      public List<Integer> rightSideView_DFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Deque<TreeNode> valStack = new ArrayDeque<>();
        Deque<Integer> levelStack = new ArrayDeque<>();
        valStack.push(root);
        levelStack.push(0);
        while(!valStack.isEmpty()) {
            TreeNode curr = valStack.pop();
            int level = levelStack.pop();
            if(result.size() < level+1) result.add(curr.val);
            else result.set(level, curr.val);
            
            if(curr.right != null) {valStack.push(curr.right);  levelStack.push(level+1);}
            if(curr.left != null) {valStack.push(curr.left); levelStack.push(level+1);}
        }
        return result;
    }
}
