/*
Maintain separate lists for odd and even nodes. Then Join them

Time Complexity - O(N)
Space Complexity - O(1)

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) return head; 
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while(even != null && even.next != null) {
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
