/*
Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

InterviewBit: REMDUPLNK
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
	public ListNode deleteDuplicates(ListNode a) {
	    if(a == null || a.next == null) return a;
	    
	    ListNode prev = a;
	    ListNode curr = a.next;
	    
	    while(curr != null) {
	        if(prev.val != curr.val) {
	            prev.next = curr;
	            prev = prev.next;
	            curr = curr.next;
	        } else {
	            curr = curr.next;
	        }
	    }
	    prev.next = null;
	    return a;
	}
}
