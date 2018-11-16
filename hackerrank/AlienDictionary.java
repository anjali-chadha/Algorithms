import java.io.*;
import java.util.*;


/* 
Alien Dictionary:
Topological ordering is possible if and only if the graph has no directed cycles.

Approach 1: BFS

Approach 2: DFS

*/


class Solution {

  public static void main(String[] args) {
    Solution o = new Solution();
    String[] words = new String[]{
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
      };
    System.out.println(o.alienOrder(words));
  }  
  
  public String alienOrder(String[] words) {
    if(words == null || words.length == 0) return "";
    if(words.length == 1) return words[0];
    
    Map<Character, Set<Character>> adjMap = new HashMap<>();
    Map<Character, Integer> inDegreeMap = new HashMap<>();
    buildGraph(words, adjMap, inDegreeMap);
    return topologicalSort(adjMap, inDegreeMap);
  }
  
  private String topologicalSort(Map<Character, Set<Character>> adjMap, Map<Character, Integer> inDegreeMap) {
    Queue<Character> bfsQ = new LinkedList<>();
    //Initially add all chars with indegree 0
    for(char c: inDegreeMap.keySet()) {
      if(inDegreeMap.get(c) == 0)  bfsQ.offer(c);
    }
    
    StringBuilder result = new StringBuilder();
    while(!bfsQ.isEmpty()) {
      char cFront = bfsQ.poll();
      result.append(cFront);
      for(char c: adjMap.get(cFront)) {
        inDegreeMap.put(c, inDegreeMap.get(c)-1);
        if(inDegreeMap.get(c) == 0) bfsQ.offer(c);
      }
    }
    return result.length() == inDegreeMap.size()? result.toString(): "";
  }
  
  private void buildGraph(String[] words, Map<Character, Set<Character>> adjMap, Map<Character, Integer> inDegreeMap) {
    for(String w: words) {
      for(char c: w.toCharArray()) {
        inDegreeMap.putIfAbsent(c, 0);
        adjMap.putIfAbsent(c, new HashSet<>());
      }
    }
    for(int i = 0; i < words.length-1; i++) {
      String first = words[i];
      String second = words[i+1];
      
      int length = Math.min(first.length(), second.length());
      for(int j = 0; j < length; j++) {
        char parent = first.charAt(j);
        char child = second.charAt(j);
        if(parent != child) {
          Set<Character> set = adjMap.get(parent);
          if(!set.contains(child)) {
            set.add(child);
            //Increment in-degree of the child char
            inDegreeMap.put(child, inDegreeMap.get(child) + 1);
          }
          break; //When I find first set of unmatching characters, don't do further matching for given two strings
        }
      }
    }
    
  }
}
