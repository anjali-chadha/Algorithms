//https://leetcode.com/problems/unique-paths
/**
* Approach 1 : Below Implementation
* Time Complexit - O(m*n), Space Complexity - O(m * n)
* 
* Approach 2: Space Complexity reduced to O(n)
* Converting 2D memo array to 1-D because at every step we need only two values.
*
* Approach 3: Directly using formula.. Since the robot is going either down or right, 
* Total number of possible steps = (m-1) + (n-1) = m+n-2
* Number of unique Paths = (m+n-2)C(m-1)
*/
class Solution {
   
   //Using 2-D Dp Array
    public int uniquePaths_1(int m, int n) {
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
   

   //Using 1-D memo Array
    public int uniquePaths_2(int m, int n) {
        if(m == 1 || n == 1) return 1;
        int[] memo = new int[n];
        
        //First row - all values set to 1
        for(int i = 0; i < n; i++) memo[i] = 1;
        
        //Go through remaining m-1 rows
        for(int i = 1; i < m; i++) {
            //Update memo[] values for each row
            for(int j = 1; j < n; j++) {
                memo[j] = memo[j] + memo[j-1];
            }
        }
        
        return memo[n-1];
    }   
}
