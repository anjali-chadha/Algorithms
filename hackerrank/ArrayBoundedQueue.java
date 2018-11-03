import java.io.*;
import java.util.*;

/* 
Part 1: Implement queue using an arraylist
https://algs4.cs.princeton.edu/13stacks/ResizingArrayQueue.java.html

Queue -> FIFO
Applications - 
Queue of consumers for a resource on FIFO basis
Asynchronous data processing between two processes. They will use IO buffers, pipes etc

For using Array to implement queue, consider arrray to be circular where
we will use two indices to track the start and end of the array backed queue


Operations:
  enqueue - what to do if overflow
  dequeue - underflow condition
  front - get the front of queue
  rear - get the last of queue
*/

//class ArrayBoundedQueue {
class Solution {
  
  private Object[] A;
  private int head; //index of first element of the queue
  private int tail; //index of last element of the queue
  private int capacity;
  private int size;
  
  public Solution(int capacity) {
    A = new Object[capacity];
    this.capacity = capacity;
    head = 0; //queue is empty
    tail = 0;
    size = 0;
  }
  
  public void enqueue(Object o) {
    if(isFull()) return; //or throw Overflow Exception
    A[tail++] = o;
    if(tail == capacity) tail = 0;
    size++;
  }
  
  //Removing the element from the front
  public Object dequeue() {
    if(isEmpty()) return null; //or throw Underflow Exception
    Object frontElement = A[head];
    A[head] = null;
    size--;
    head++;
    if(head == capacity) head = 0; //wrap-around
    return frontElement;
  }
  
  public Object getFront() {
    if(isEmpty()) return null;
    return A[head];
  }
  
  public Object getRear() {
    if(isEmpty()) return null; //or throw exception
    return A[tail];
  }
  
  public boolean isEmpty() {
    return size == 0; 
  }
  
  public boolean isFull() {
    return capacity == size; 
  }
  
  public void printQueue() {
    for(Object o: A) 
      System.out.println(o);
  }
  
  public static void main(String[] args) {   
    Solution q = new Solution(5);
    q.enqueue(4);
    q.dequeue();
    q.enqueue(5);
    q.enqueue(6);
    q.printQueue();
  }

}

