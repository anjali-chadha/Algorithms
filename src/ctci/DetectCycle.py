# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the first node in the cycle in the linked list
    
    # Using Extra memory    
     def detectCycle_v1(self, A):
           visited_nodes = set()
           while A:
               if A in visited_nodes:
                   return A
               else:
                   visited_nodes.add(A)
                   A = A.next    
                
   
    def detectCycle_v2(self, A):
        if not A or not A.next:
            return None
            
        slow = A
        fast = A
        while slow and fast and fast.next:
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
