/*
Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
Try solving it using constant additional space.
InterviewBit: LISTCYCLE
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
	//Using Floyd's Cycle-Finding Algorithm
	public ListNode detectCycle(ListNode a) {
	    if(a == null || a.next == null) return null;
	    
	    ListNode slow = a;
	    ListNode fast = slow;
	    
	    while(slow != null && fast != null && fast.next != null) {
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow == fast) return findStartingCyclicNode(a, slow, fast);
	    }
	    return null;
	}
	
	private ListNode findStartingCyclicNode(ListNode head, ListNode slow, ListNode fast) {
	    int cycleLength = 1;
	    slow = slow.next;
	    while(fast != slow) {
	        slow = slow.next;
	        cycleLength++;
	    }
	    
	    //Assign fastNode ahead of head node by the length of cycle.
	    fast = head;
	    for(int i = 0; i< cycleLength; i++) {
	        fast = fast.next;
	    }
	    
	    //Now start traversing from the head node
	    slow = head;
	    while(slow != fast) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    return slow;    
	}
}
