/**
https://leetcode.com/problems/word-search

Algorithm: DFS
Time Complexity: O(MN * 3^K) where K is the length of the input word & MN are board dimensions
"(n^2 * 4 * 3^(k-1)) = O(n^2 * 3^k).
Explanation: We start the word search over all n^2 nodes. For the first letter of the word search
we can move in 4 directions but for every later one there are only three options (you can't move back onto yourself)."

Space Compelxity: O(K) where K represents the length of the word
Stack space used while recursion

Questions:
Can we modify the input array? 
Are all the characters ASCII?
If both answers yes, can solve the problem in O(1) space complexity
**/

class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null || board.length == 0 || board[0].length == 0) return false;
        if(word.isEmpty()) return true;
        
        //Maintaining a visited array
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(boolean[] A: visited) Arrays.fill(A, false);
        for(int i = 0; i< m; i++) {
            for(int j = 0; j<n; j++) {
                if(dfs(board, word.toCharArray(), 0, visited, i, j)) return true;
            }
        }
         return false;
    }
    
    private boolean dfs(char[][] board, char[] word, int idx, boolean[][] visited, int R, int C) {
        if(idx == word.length) return true;
        int m = board.length, n = board[0].length;
        if(R < 0 || R >= m || C < 0 || C >= n || 
           visited[R][C] ||   //if that word is already visited
           board[R][C] != word[idx]) return false;
        
        visited[R][C] = true;
        
        if(dfs(board, word, idx+1, visited, R+1, C) ||
          dfs(board, word, idx+1, visited, R-1, C) ||
          dfs(board, word, idx+1, visited, R, C+1) ||
          dfs(board, word, idx+1, visited, R, C-1) ) return true;
        
        visited[R][C] = false;
        return false;
    }
}
