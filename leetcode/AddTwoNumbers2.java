/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        Deque<Integer> stack1 = new ArrayDeque<>();
        Deque<Integer> stack2 = new ArrayDeque<>();
        
        ListNode dummy1 = l1;
        ListNode dummy2 = l2;
        while(dummy1 != null) {
            stack1.push(dummy1.val);
            dummy1 = dummy1.next;
        }
         while(dummy2 != null) {
            stack2.push(dummy2.val);
            dummy2 = dummy2.next;
        }
        
        int sum = 0;
        ListNode result = new ListNode(0);
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            if(!stack1.isEmpty()) sum += stack1.pop();
            if(!stack2.isEmpty()) sum += stack2.pop();
            
            result.val = sum%10;
            ListNode head = new ListNode(sum/10);
            head.next = result;
            result = head;
            sum /= 10;
        }
        return result.val == 0? result.next : result;        
    }
}
