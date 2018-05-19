/*
Given a positive integer N, print all the integers from 1 to N. 
But for multiples of 3 print “Fizz” instead of the number and for the multiples of 5 print “Buzz”. Also for number which are multiple of 3 and 5, prints “FizzBuzz”.

Example
N = 5
Return: [1 2 Fizz 4 Buzz]
*/
public class Solution {
    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> result = new ArrayList<>();
        
        //Error handling
        if(A <= 0) return result;
        for(int i = 1; i <= A; i++) {
            if(i % 15 == 0) result.add("FizzBuzz");
            else if(i%3 == 0) result.add("Fizz");
            else if(i%5 == 0) result.add("Buzz");
            else result.add((""+i));
        }
        return result;
    }
}
