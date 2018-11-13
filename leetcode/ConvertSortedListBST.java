/*
Approach 1: Bottom Up recursion
Using a global variable to track the current node in linked list
Time Complexity - O(N)
Space Complexity - O(log N) - stack space
Very similar to binary search

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    
    private ListNode nodeList;
    
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        int len = findLength(head);
        nodeList = head;
        return bottomUpBst(0, len - 1);
    }
    
    private TreeNode bottomUpBst(int start, int end) {
        if(start > end) return null;
        int mid = start + (end - start)/2;
        TreeNode left = bottomUpBst(start, mid - 1);
        TreeNode node = new TreeNode(nodeList.val);
        node.left = left;
        nodeList = nodeList.next;
        node.right = bottomUpBst(mid + 1, end);
        return node;
    }
    
    private int findLength(ListNode node) {
        ListNode curr = node;
        int val = 0;
        while(curr != null) {
            curr = curr.next;
            val++;
        }
        return val;
    }
}
