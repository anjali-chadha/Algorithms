import java.io.*;
import java.util.*;

/* 
Interview Process: Affinity
Given a string of HTML tags, construct a tree to represent it.


INPUT:
------
A string of HTML tags. Examples:
1. "<divA><divB></divB></divA>"

Tree-
    divA
    |
    divB

O/P
div
-div
=============
Stack- 
<divA>
<divA><DivB>
Check in my stack--> Pop the top element
<divA> --> Check in my stack //Pop

Split it by "><"
O/P - <div, div, /div, /div>
div
-div

2. "<html><head><style></style></head><body><h1></h1><div><div></div><a></a><a></a></div></body></html>" (indented below for your visual convenience)

Stack-- Pointer to Nodes in Tree
a div body html 

<html>
  <head>
    <style></style>
  </head>
  <body>
    <h1></h1>
    <div>
      <div></div>
      <a></a>
      <a></a>
    </div>
  </body>
</html>

===
Tree
                html
        |            | 
        head         body
        |            |    |
                    h1    div
    style                |  |     |
                        div   a    
                        


PROBLEM:
--------
(1) Parse the string into a data structure that represents these HTML tags. The data structure MUST be a tree.

(2) Write a function that pretty-prints the tree in the following format so that we can verify correctness. Example of pretty-printing:

html
-head
--style
-body
--h1
--div
---div
---a
---a


Assume all of the following about the input string:
- Only HTML open and close tags. There are no DOCTYPEs, no attributes within tags (<div class="...">) and no self-closing tags (<div />).
- Correctly formatted. Every opening tag is properly formatted, and is guaranteed to have a corresponding closing tag.

TIPS:
- You can choose a language and run your code. Click Run as much as you want!
- Don't worry too much about algorithmic complexity. Focus on getting a working version first, before optimizing your code. 
- Feel free to explain your code as you write it, but this is not required--we'd rather see more progress towards completion.
- We're looking for your speed, communication of ideas, decomposition, and ability to write clean and functional code.

 */


class Solution {
  public static void main(String[] args) {
    String in = "<divA><divB></divB></divA>";
    String in2 = "<html><head><style></style></head><body><h1></h1><div><div></div><a></a><a></a></div></body></html>";
    
    htmlToTree(in2);
    
  }
static class Node {
 String val; 
 List<Node> child; 
  Node(String val) {
   this.val = val; 
  }
  public String toString() {
    return "["+val+"]-->" + ((child == null)? "" :child.toString()); 
  }
}

//O/P - <div, div, /div, /div>
/**

    div
      |
      div
      
      
o/p 
div
**/

  private static void inorder(Node node) {
 if(node == null) return ;
  System.out.println(node.val);
  if(node.child != null) {
    for(Node n: node.child) inorder(n);
  }
}
private static String traverseTree(Node node, String output, String prefix) {
  if(node == null) return output;
  output += node.val + "\n";

  prefix += '-';
  if(node.child != null) {
    for(Node n: node.child) 
       output += prefix + traverseTree(n, "", prefix);
  }
  return output;
}

public static void htmlToTree(String s) {
  if(s == null || s.isEmpty()) return ;
  
  Stack<Node> stack = new Stack<>();
  String[] A = s.split("><");
  for(int i = 0; i < A.length - 1; i++) {
    String tag = A[i];
    if(isClosingTag(tag)) {
      stack.pop();
    } else {
      //Opening Tag
      Node n = new Node(tag.replace("<", ""));
      if(!stack.isEmpty()) {
       //Root Node
        Node parent = stack.peek();
        if(parent.child == null) {
          parent.child = new ArrayList<>();
        }
         parent.child.add(n);
      }
      stack.push(n);
    }
  }
  
  Node root = stack.pop();
  //System.out.println(root);
  //inorder(root);
  //System.out.println("\n");
  System.out.println(traverseTree(root, "", ""));
}


private static boolean isClosingTag(String s){
 return s.charAt(0) == '/';
}

}
