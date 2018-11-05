/*
Solution 1: Using 2 stacks

Solution 2: Calculate the difference betweeen the lists lengths
Use recursion to solve from the right to left
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


class Solution2 {
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        int size1 = getLength(l1);
        int size2 = getLength(l2);
        ListNode result = new ListNode(1);
        int[] carry = new int[1];
        
        if(size1 == size2) addSameSize(l1, l2, result, carry);
        else {
            //List1 should be the bigger one
            if(size1 < size2) {
                ListNode temp = l1;
                l1 = l2;
                l2 = temp;
            }
            
            int diff = Math.abs(size1- size2);
            
            ListNode temp = l1;
            while(diff > 0) {
                diff--;
                temp = temp.next;    
            }
            
            addSameSize(temp, l2, result, carry);
           
            diff = Math.abs(size1- size2);
            propagateCarry(l1, result, carry, diff);
        }
        if(carry[0] > 0) {
            return result;
        }
        return result.next;
    }
 
    private void propagateCarry(ListNode l1, ListNode result, int[] carry, int diff) {
        if(diff == 0) return;
        propagateCarry(l1.next, result, carry, diff-1);
        int sum = l1.val + carry[0];
        carry[0] = sum/10;
        sum %= 10;
        ListNode newNode = new ListNode(sum);
        ListNode temp = result;
        newNode.next = temp.next;
        result.next = newNode;
    }
    
    private void addSameSize(ListNode l1, ListNode l2, ListNode result, int[] carry) {
        if(l1 == null) return;
        addSameSize(l1.next, l2.next, result, carry);
        int sum = l1.val + l2.val + carry[0];
        carry[0] = sum/10;
        sum = sum%10;
        ListNode newNode = new ListNode(sum);
        ListNode temp = result;
        newNode.next = temp.next;
        result.next = newNode;
    }
    
    private int getLength(ListNode node) {
        int size = 0;
        
        while(node != null) {
            size++; node = node.next;
        }
        return size;
    }
}
