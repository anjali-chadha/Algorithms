

import java.util.*;
import java.lang.*;
import java.io.*;
/**		Given a string with alpha-numeric characters and parentheses, return a string with 
 * balanced parentheses by removing the fewest characters possible. You cannot add anything to the string.
* Example : (((ab)
* ans : (ab)
* Eg : ()()
* ans :()()
* Eg: ))((ab  
* ans : ab
* 
* 
* Approach 1: Using Stack to keep track of opening brackets count
* Time and Space Complexity - O(N)
*
* Approach 2: Wihtout using Stack, count the number of paranthesis
* Space Complexity - O(1) 
**/


class Solution
{
	public String balanceParanthesis(String s) {
	  if(s == null || s.isEmpty()) return "";
	 
	  //can be removed
	  Deque<Character> stack = new ArrayDeque<>();
	  Deque<Character> stackIndx = new ArrayDeque<>();
	  boolean[] indexes = new boolean[s.length()];
	  Arrays.fill(indexes, false);
	 
	  for(int i = 0; i < s.length(); s++) {
	    char c = s.charA(i);
	    if(isClosingBracket(c)) {
	        if(stack.isEmpty()) {indexes[i] = true;}
	        else {
	          stack.pop();
	          stackIndx.pop();
	        }
	    } else if(isOpeningBracket(c)) {
	        stack.push('(');
	        stackIndx.push(i);
	    }
	    
	    }
	    while(!stack.isEmpty()) {
	      stack.pop();
	      int i = stackIndx.pop();
	      index[i] = true;
	    }
	 
	    StringBuilder result = new StringBuilder();
	    for(int i = 0; i < indexes.length; i++) {
	      if(!indexes[i]) result.append(s.charAt(i));
	    }
	    return result.toString();
	}
	
	private boolean isOpeningBracket(char c) {
	  return c == '(';
	}
	
	private boolean isClosingBracket(char c) {
	  return c == ')';
	}
	        
	        
	public String balanceParanthesis_OPt(String s) {
	  if(s == null || s.isEmpty()) return "";
	
	  int L = 0;
	  int R = s.length() - 1;
	 
	  while(L < R) {
	    char leftChar = s.charAt(L);
	    while(is)  
	    char rightChar = s.charAt(R);
	    if(isClosingBracket(rightChar) && isOpeningBracket(leftChar)) {
	        L++; R--;
	    }
	    
	  }
	}

}
