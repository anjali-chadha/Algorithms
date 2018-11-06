/*
This is a variation of the standard problem: “Counting the number of connected components in an undirected graph”.
To solve the SCC problem - Can use both DFS and BFS
Time Complexity of SCC - O(V+E) - Same as DFS algorithm 

Algorithm 1: Use DFS
Traverse each cell in the grid.
If it's a 1 (an island). 
  Do DFS to mark all adjacent islands
  Increase the counter by 1.

Time Complexity - Same as DFS - O(MN + 4*MN) = O(Vertices + Edges) = O(MN)
Space Complexity - O(1) //No Extra space used
However modifying the original input which is not recommended. 
Alternative is to use a visited boolean 2D array
*/

class Solution {
    public int numIslands(char[][] grid) {
        //corner cases
        if(grid == null) return 0;
        int m = grid.length; 
        if(m == 0) return 0;
        int n = grid[0].length;
        if(n == 0) return 0;
        
        int result = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    result++;
                }
            }   
        }
        return result;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length ||
          grid[i][j] != '1') return;
        
        grid[i][j] = '0';
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
    }
}
