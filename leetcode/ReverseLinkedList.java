/*
Algorithm 1: Iterative
Use 2 pointer variables to store prev and next pointer
Space Complexity - O(1)
Time Complexity - O(N)

Algorithm 2: Recursive
Time Complexity - O(N)
Space Complexity - O(N) Recursion stack could go N level deeper

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList_1(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }
        return prev;
    }
    
     public ListNode reverseList_2(ListNode head) {
        if(head == null || head.next == null) //If list is empty or one element left
            return head;
        ListNode tmp = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
