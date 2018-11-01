import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/* 
 * Implement an iterator for list of lists with the following methods:

    boolean hasNext() return true if there is another element in the set
    int next() return the value of the next element in the array
    void remove() remove the last element returned by the iterator. That is, remove the element that the previous next() returned. This method can be called only once per call to next(), otherwise an exception will be thrown.

 [[1,2],[3,4],[5,6]]
 [[1,2],[3,4],[],[],[5,6]]

TIPS:
- You can choose a language and run your code. Click Run as much as you want!
- Don't worry too much about algorithmic complexity. Focus on getting a working version first, before optimizing your code. 
- Feel free to explain your code as you write it, but this is not required--we'd rather see more progress towards completion.
- We're looking for your speed, communication of ideas, decomposition, and ability to write clean and functional code.



//Anjali
1) To safely remove from the collection, use the Iterator 
Example of using an iterator-
Iterator<String> i = list.iterator();
while(i.hasNext()) {
  String s = i.next(); //invoke next() before caling the remove()
  i.remove();
}

2) Case where after removal the corresponding row becomes empty()
*/



class ListIterator1 {
  private int R = 0;
  private int C = 0;
  private int size;
  
  private List<List<Integer>> list;
  
  public ListIterator1(List<List<Integer>> list) {
    this.list = list;
    size = list.size();
  }
  
  public boolean hasNext() {
    if(list == null || list.isEmpty()) return false;
    
    //Check index boundary
    while(R < size) {
      if(C < list.get(R).size()) return true;
      //Increment to the correct row if required.
      R++; 
      C = 0;
    }
    return false;
  }
  
  public Integer next() {
    Integer val = list.get(R).get(C);
    C++; 
    //Only increment the column here. Row increments will be handled in the hasNext() call if required
    return val;
  }
  
  public void remove() throws Exception {
    int removeR = R;
    int removeC = C;
    if(C == 0) {
      removeR = R-1;
      removeC = list.get(removeR).size() - 1;
      list.get(removeR).remove(removeC);
    } else {
      removeC--;
      list.get(removeR).remove(removeC);
    }
    
    //If the list becomes empty after remove operation
    if(list.get(removeR).isEmpty()) {
      list.remove(removeR);
      R--;
    }
    
    //Since we have deleted an element, reduce the C by 1
    C--;
  }
  
}


class ListIterator2 implements Iterator<Integer>{
  private Iterator<List<Integer>> outerItr;
  private Iterator<Integer> innerItr;
  
  public ListIterator2(List<List<Integer>> list) {
    //if(list == null) //throw exception
  
    outerItr = list.iterator();
    innerItr = Collections.emptyIterator();
  }
  
  @Override
  public boolean hasNext() {
    if(outerItr.hasNext() && (innerItr == null || !innerItr.hasNext())) {
      innerItr = outerItr.next().iterator();
    }
    return (innerItr != null) &&  (innerItr.hasNext());
  }
  
  @Override
  public Integer next() {
    return innerItr.next();
  }
  
  
  //Throws unchecked IllegalStateException depending on the Iterator implementation
  @Override 
  public void remove() {
  //TODO
    
  }
}


class Solution {

  //4:33PM
  public static void main(String[] args) {
    Solution o = new Solution();
  } 
}
