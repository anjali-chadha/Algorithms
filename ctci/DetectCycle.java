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
	// Using HashSet (extra space used)
	public ListNode detectCycle_v1(ListNode a) {
	    if(a == null || a.next == null) return null;
	    
	    HashSet<ListNode> nodeSet = new HashSet<>();
	    ListNode node = a;
	    while(node != null) {
	        if(nodeSet.contains(node)) return node;
	        nodeSet.add(node);
	        node = node.next;
	    }
	    return null;
	}	
	
	//Using Floyd's Cycle-Finding Algorithm
	// Space Complexity - O(1)
	public ListNode detectCycle_v2(ListNode a) {
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
