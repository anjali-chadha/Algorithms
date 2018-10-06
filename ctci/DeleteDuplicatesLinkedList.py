# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param A : head node of linked list
    # @return the head node in the linked list
    def deleteDuplicates(self, A):
        if not A or not A.next:
            return A
        
        prev = A
        curr = A.next
        
        while curr:
            if prev.val == curr.val:
                curr = curr.next
            else:
                prev.next = curr
                prev = prev.next
                curr = curr.next
        prev.next = None
        return A
