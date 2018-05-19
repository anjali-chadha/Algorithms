class Solution:
	# @param A : integer
	# @return a list of strings
    def fizzBuzz_v1(self, A):
        
        result = []
        for x in range(1, A+1):
            if x%15 == 0:
                result.append("FizzBuzz")
            elif x%3 == 0:
                result.append("Fizz")
            elif x%5 == 0:
                result.append("Buzz")
            else:
                result.append(str(x))
        return result

    ## Faster solution
    def fizzBuzz(self, A):
        
        result = list(range(1, A+1))
        for i in range(2, A, 3):
            result[i] = "Fizz"
        for i in range(4, A, 5):
            if result[i] == "Fizz": 
                result[i] += "Buzz"
            else:
                result[i] = "Buzz"
        
        return result
