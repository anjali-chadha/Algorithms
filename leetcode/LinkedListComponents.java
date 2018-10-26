/**
* https://leetcode.com/problems/linked-list-components
* Time Complexity - O(N)
* Space Complexity - O(N)
*
* Approach 2 - Cleaner & Concise code
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] G) {
        if(head == null || G == null || G.length == 0) return 0;
        
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: G) set.add(i);
        
        ListNode current = head;
        while(current != null) {
            if(set.contains(current.val)) {
                result++;
                current = current.next;
                while(current != null && set.contains(current.val)) {
                    current = current.next;
                }
            } else
                current = current.next;
        }
        
        return result;
    }
    
     public int numComponents_2(ListNode head, int[] G) {
        if(head == null || G == null || G.length == 0) return 0;
        
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i: G) set.add(i);
        
        while(head != null) {
            if(set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) result++;
                head = head.next;
               }
        return result;
    }
}
