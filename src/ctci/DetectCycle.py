# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the first node in the cycle in the linked list
    def detectCycle(self, A):
        if A is None or A.next is None:
            return None
            
        slow = A
        fast = A
        while not slow is None and not fast is None and not fast.next is None:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return self.find_start_node(A, slow, fast)
        return None                
            
    def find_start_node(self, head, ptr1, ptr2):
        len_cycle = 1
        ptr1 = ptr1.next
        while not ptr1 == ptr2:
            ptr1 = ptr1.next
            len_cycle += 1
        
        # Increment one pointer len_cycle times ahead of head
        ptr1 = head
        ptr2 = head
        for i in range(len_cycle):
            ptr2 = ptr2.next
        
        while not ptr1 == ptr2:
            ptr1 = ptr1.next
            ptr2 = ptr2.next
        return ptr1
