package leetcode;

/**
 * Definition for singly-linked list.
 */

public class MergeTwoLL {
     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        ListNode head3 = null;
        if(l1.val < l2.val) {
            head3 = l1;
            l1 = l1.next;
        } else {
            head3 = l2;
            l2 = l2.next;
        }
        head3.next = null;
        ListNode current = head3;
        while(l1 != null && l2 != null && current != null)
        {
            if(l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;

            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
            current.next = null;
        }

        if (l1 == null) current.next = l2;
        else if (l2 == null) current.next = l1;

        return l1;
    }

    public static void main(String[] args) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(1);
         ListNode l3 = new ListNode(2);
         ListNode l4 = new ListNode(3);
         ListNode l5 = new ListNode(4);
         ListNode l6 = new ListNode(4);

         l1.next = l3;
         l3.next = l5;
         l2.next = l4;
         l4.next = l6;

        MergeTwoLL o = new MergeTwoLL();
        o.mergeTwoLists(l1, l2);
    }
}

