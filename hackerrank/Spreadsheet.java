import java.io.*;
import java.util.*;

/* 
Interview: Asked in Affinity 
Implement a spreadsheet where cells need to support string values like “Sunday” and “10”. Cells are identified by A1 or C3. You can assume at most 26 columns, namely A to Z, but no bounds exist for the number of rows. 

Implement an API to: 
  A. Set a cell value. Accepts a string value.
  set(String val, int i, int j, A(TODO))
  B. Get a cell value. Returns a string value.
    get(int i, int j)

Apporach 1:
Map<Pair(i, j), InputValue> - 
set() --> update hashmap - O(1)
get() -> O(1)
(i, j)
(0, 0) , (100000, 100)

Implement the ability to enter formulas into cells. 
You can assume simple expressions of the form “= 10 + 23 - 2” and only integer operands. There will always be a single space between an operator and an operand.
You only need to support +/- and you can assume a left-to-right order of evaluation.

"10 + 23 - 2"
Split by spaces
10, +, 23, -, 2
0,  1,  2, 3, 4

Odd indices - Operands
Even indices - Integers

Implement the ability to use other cell values as operands in a formula. e.g. “= A2 + B3 - 10” is a valid formula.
*/

class Solution {
  
  private Map<String, String> map;
  
  Solution() {
    map = new HashMap<>(); 
  }
  
  public static void main(String[] args) {
      Solution o = new Solution();
      o.set("Obama", "A", "100");
      o.set("Trmp", "B", "100");
      o.set("Lincoln", "B", "100");
      o.set("", "B", "600");
      o.set( "= 10 - 2", "C", "600");  //8
      o.set( "= 10 + 2", "D", "600"); //12
      o.set( "= 10 + 23 - 2", "E", "600"); //31
      o.set( "= 10", "F", "600"); //10
      o.set( "= 0 + 0", "G", "600"); //0
      o.set( "= -10 - 10", "H", "600"); //-20
      o.set( "= -2", "I", "600");       //-2
      o.set( "= -10 + 2", "J", "600"); //-8
      o.set( "= 10 + 23 - 2 - 2 + 2", "K", "600"); //31 
    
     assert(o.get("A", "100") == "Obama");
     assert(o.get("B", "100") == "Lincoln");
     assert(o.get("C", "100") == "");
     assert(o.get("B", "600") == "");
     assert(o.get("C", "600").equals("8"));
     assert(o.get("D", "600").equals("12"));
     assert(o.get("E", "600").equals("31"));
     assert(o.get("F", "600").equals("10"));
     assert(o.get("G", "600").equals("0"));
     assert(o.get("H", "600").equals("-20"));
     assert(o.get("I", "600").equals("-2"));
     assert(o.get("J", "600").equals("-8"));
    
    
  }
  
  //"A3"
  public void set(String val, String i, String j) {
    String cell = i+j;
    String finalVal = val;
    if(isFormula(val)) {
      val = evaluateFormula(val);
    }
    map.put(cell, val);
  }
  
  public String get(String i, String j) {
    String cell = i+j;
    String output = map.get(cell);
    return output == null? "": output;
  }
  
  private boolean isFormula(String s) {
   return (!s.isEmpty() && s.charAt(0) == '='); 
  }
  
  //S = "= 10 - 2"
  private String evaluateFormula(String s) {
    //Eroor chekcing - Skip
    String[] A = s.split(" ");
    int result = 0;
    char c = '+';
    
    for(int i = 1; i < A.length; i++) {
      if(i%2 != 0) {
        //Integer or cell value
        int val = 0;
        if(isCellValue(A[i])) {
          val = map.get(A[i]) == null? 0: Integer.parseInt(map.get(A[i]));
        } else {
            val = Integer.parseInt(A[i]);
        }
        result = evaluateOperand(result, val, c); 
      } else {
       c = A[i].charAt(0); 
      }
    }
    return result+"";
  }
  
  private int evaluateOperand(int i, int j, char op) {
  
   if(op == '+') return i+j;
   if(op == '-') return i-j;
    return Integer. MAX_VALUE; //Throw error
  }
  
  private boolean isCellValue(String s) {
   return !s.isEmpty() && !Character.isDigit(s.charAt(0));
  }
}

