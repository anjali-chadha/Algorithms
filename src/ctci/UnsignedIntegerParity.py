class Solution:
    # @param A : integer
    # @return an integer
    def numSetBits(self, A):
        count = 0
        while not A == 0:
            count += 1
            A = A & (A - 1)
        return count
