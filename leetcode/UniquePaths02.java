/**
* https://leetcode.com/problems/unique-paths-ii/
* Approach 1: Using memoization and DP (Similar to Unique Paths 1)
* Time Complexity - O(m*n), Space Complexity - O(m*n)
*
* Approach 2: Same technique. We don't need to create an M*N memoization array to store the intermediate values
* Everytime during the update operation we use only two values - memo[i-1][j] and memo[i][j-1]
* Reduce the space complexity from O(m*n) to O(n)
*/

class Solution {
    public int uniquePathsWithObstacles_1(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if(obstacleGrid[i][j] == 1) {memo[i][j] = 0; continue;}
                if(i == 0 && j == 0) memo[i][j] = 1;
                else if(i == 0) memo[i][j] = memo[i][j-1];
                else if(j == 0) memo[i][j] = memo[i-1][j];
                else memo[i][j] = memo[i-1][j] + memo[i][j-1];
        }
    }
    return memo[m-1][n-1];
}

  public int uniquePathsWithObstacles_2(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) return 0;
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1) return 0;
        int[] memo = new int[n];
        memo[0] = 1;
        //First row
        for(int i = 1; i < n; i++) {
            if(obstacleGrid[0][i] == 1) memo[i] = 0;
            else memo[i] = memo[i-1];
        }
        
        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++)  {
                if(obstacleGrid[i][j] == 1) memo[j] = 0;
                else if(j > 0) {
                    memo[j] += memo[j-1];
                }
        }
    }
    return memo[n-1];
}
}
