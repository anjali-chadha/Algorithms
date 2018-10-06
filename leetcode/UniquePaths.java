class Solution {
    
    // First Method
    // Using Dynamic Programming 
    // Time and Space Complexity - O(m*n)
    public int uniquePaths_v1(int m, int n) {
        
        //Corner Cases
        if(m <=0 || n <= 0) return 0;
        if(m == 1 && n ==1) return 1;
        
        int[][] result = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(i == 0 && j ==0) {result[i][j] = 0;}
                else if(i == 0 || j == 0) { result[i][j] = 1;}
                else {result[i][j] = result[i-1][j] + result[i][j-1];}
            }
        }
        return result[m-1][n-1];
    }
    
    // Recursive - Intuitive yet inelegant solution
    // Same calculations occuring multiple times
    // Time Complexity - Exponential
     public int uniquePaths_v2(int m, int n) {
        if(m <= 0 || n <= 0) {return 0;}
        if(m == 1 || n == 1) {return 1;}
        
        return uniquePaths(m-1, n) + uniquePaths(m, n-1);
    }
    
    // Third method
    // Using Mathemetical formula.
    // To reach the end point, the user has to take m - 1 horizontal and n - 1 vertical steps in any sequence
    // Permutation of these steps = (m + n -2)! / (m - 1)! (n - 1)!
}
