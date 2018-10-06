class Solution:
    def countPrimes(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n <= 1:
            return 0
        isPrime = [True] * n
        isPrime[0] = False
        isPrime[1] = False
        
        i = 2
        while i*i <= n:
            for j in range(2*i, n, i):
                isPrime[j] = False
            i += 1
        
        count = 0
        for p in range(n):
            if isPrime[p]:
                count += 1
        return count
