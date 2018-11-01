import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/* 
Your previous Plain Text content is preserved below:
Given:
An array of strings where "L" indicates land and "W" indicates water, and a coordinate marking a starting point in the middle of the ocean

The Challenge:
Find and mark the ocean in the map by changing appropriate W's to O's. An ocean coordinate is defined to be any coordinate directly adjacent to any other ocean coordinate
//Assumptions:
1) The point X, Y has to be 'O
2) What if the point is already an 'O
*/


class Solution {

  public static void main(String[] args) {
    Solution o = new Solution();
    List<String> list = new ArrayList<>();
    list.add("LWWWWWW");
    list.add("LLWWWWW");
    list.add("LLLLLLW");
    list.add("LLLWWWW");
  
    o.findMarkOcean(list, 1,3);
    
    
  }
  
  
  //4:05 pm
  public void findMarkOcean(List<String> list, int X, int Y) {
    char[][] A  = createArray(list);
    
    int m = A.length;
    int n = A[0].length;
    
    if(X < 0 || X >= m || Y < 0 || Y >= n) return;
    if(A[X][Y] == 'O') return;
    
    dfs(A, X, Y);
    printTerrain(A);
  }
  
  private char[][] createArray(List<String> list) {
    int m = list.size();
    int n = list.get(0).length(); 
    char[][] A = new char[m][n];
    for(int i = 0; i < m; i++) {
      String s = list.get(i);
      for(int j = 0; j < n; j++) {
       A[i][j] = s.charAt(j);
      }
    }
    return A;
  }
  
  private void dfs(char[][] A, int x, int y) {
    int m = A.length;
    int n = A[0].length; 
    if(x < 0 || x >= m || y < 0 || y >= n) return;
    if(A[x][y] != 'W') return;
    A[x][y] = 'O';
    dfs(A, x-1, y);
    dfs(A, x+1, y);
    dfs(A, x, y-1);
    dfs(A, x, y+1);
  }
  
  private void printTerrain(char[][] A) {
    for(char[] list: A) {
      for(char c: list) {
        System.out.print(c);
      }
      System.out.println();
    }
  }
}
