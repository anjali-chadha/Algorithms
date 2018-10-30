/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
 
 /**
 * Algorithm 1 - Time/Space Complextiy - O(N)
 * Create mapping of old and new nodes. If a node is not present in the mapping, create and add it to map.
 * Iterative solution
 *
 * Algorithm 2 - Space Complexity Reduced to O(1)
 * Modifying the original linked list
 **/
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) return null;
        HashMap<RandomListNode, RandomListNode> old2New = new HashMap<>();
        RandomListNode oldN = head;
        
        RandomListNode newN = new RandomListNode(oldN.label);
        old2New.put(oldN, newN);
        
        //Until we reach the end of the old LinkedList
        while(oldN != null) {
            newN.random = clone(oldN.random, old2New);
            newN.next = clone(oldN.next, old2New);
            
            oldN = oldN.next; newN = newN.next;
        }
        return old2New.get(head);
    }
    
    private RandomListNode clone(RandomListNode old, HashMap<RandomListNode, RandomListNode> map) {
        if(old == null) return null;
        
        if(!map.containsKey(old)) map.put(old, new RandomListNode(old.label));
        return map.get(old);
    }
    
    // Algorithm 2
    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null) return null;
       
        
        RandomListNode ptr = head;
        
        // Pass1 - Insert new nodes into original LL
        while(ptr != null) {
            RandomListNode newN = new RandomListNode(ptr.label);        
            newN.next = ptr.next;
            ptr.next = newN;
            ptr = ptr.next.next;
        }
        
        ptr = head;
        
        // Pass2- Create random links
        while(ptr != null) {
            ptr.next.random = (ptr.random == null)? null : ptr.random.next;
            ptr = ptr.next.next;
        }
        
        //Pass 3 - Revert to original list
        ptr = head;
        RandomListNode newHead = head.next;
        RandomListNode currentNew = newHead;
        while(ptr != null) {
            ptr.next = ptr.next.next;
            currentNew.next = (currentNew.next == null)? null: currentNew.next.next;
            ptr = ptr.next;
            currentNew= currentNew.next;
        }
        return newHead;
    }
}
