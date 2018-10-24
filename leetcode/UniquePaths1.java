//https://leetcode.com/problems/unique-paths
/**
* Approach 1 : Below Implementation
* Time Complexit - O(m*n), Space Complexity - O(m * n)
* 
* Approach 2: Directly using formula.. Since the robot is going either down or right, 
* Total number of possible steps = (m-1) + (n-1) = m+n-2
* Number of unique Paths = (m+n-2)C(m-1)
*/
class Solution {
   
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int[][] memo = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i == 0 || j == 0) memo[i][j] = 1;
                else memo[i][j] = memo[i - 1][j] + memo[i][j - 1];
            }
        }    
        return memo[m-1][n-1];
    }
}
