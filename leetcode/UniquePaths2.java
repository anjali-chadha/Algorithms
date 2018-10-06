class Solution {

    // Inelegant solution. 
    // Time Complexity - O(m*n)
    // Space Complexity - O(1)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //Corner Cases
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // If starting point has an obstacle
        // If destination point has an obstacle
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {return 0;}

        if(m == 1 && n == 1) return 1;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1) { 
                    obstacleGrid[i][j] = -1;
                }
                else {
                    if(i == 0 && j == 0) obstacleGrid[i][j] = 1;
                    else if(i == 0) obstacleGrid[i][j] = obstacleGrid[i][j-1];
                    else if(j == 0) obstacleGrid[i][j] = obstacleGrid[i-1][j];
                    else {
                        int topRow = obstacleGrid[i-1][j];
                        topRow = (topRow == -1) ? 0: topRow;

                        int leftColumn = obstacleGrid[i][j-1];
                        leftColumn = (leftColumn == -1)? 0: leftColumn;
                        obstacleGrid[i][j] = topRow + leftColumn;
                    }
                }
            }
        }
        return obstacleGrid[m-1][n-1];   
    }
}
