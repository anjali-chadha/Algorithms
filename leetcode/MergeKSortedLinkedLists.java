//https://leetcode.com/problems/merge-k-sorted-lists/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0 ) return null;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        ListNode head = new ListNode(0); //DummyNode
        ListNode current = head;
        
        for(ListNode item: lists) {
            if(item != null) minHeap.offer(item);
        }
        
        while(!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            current.next = min;
            if(min.next != null) minHeap.offer(min.next);
            current = min;
        }
        return head.next;
    }
}
