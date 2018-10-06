package leetcode;

class PalindromicList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;

        int len = length(head);

        // System.out.println(len);
        int mid = 0;
        if(len%2 == 0) mid = len/2;
        else mid = len/2 + 1;

        int itr = 0;
        ListNode first = head;
        ListNode second = head;
        while(itr++ != mid) {
            second = second.next;
        }

        second = reverseList(second);
        //System.out.println(second.val);
        while(second != null) {
            if(second.val != first.val) return false;
            second = second.next;
            first = first.next;
        }
        return true;
    }

    private int length(ListNode node) {
        int i = 0;
        while(node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    private ListNode reverseList(ListNode head) {
        ListNode reverseHead = null;
        ListNode current = head;

        while(head != null) {
            ListNode next = head.next;
            head.next = reverseHead;
            reverseHead = current;
            head = next;
        }
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2= new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(2);
        node1.next = node2;
        node2.next = node4;
        node4.next = node3;
        PalindromicList o = new PalindromicList();
        o.isPalindrome(node1);
    }
}
