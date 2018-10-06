package leetcode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null  || head.next == null) return false;
        ListNode fast = head, slow = head;

        while(fast != null) {
            slow = slow.next;
            fast = fast.next == null? null : fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
