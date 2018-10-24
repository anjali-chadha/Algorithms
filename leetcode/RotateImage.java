/**
* https://leetcode.com/problems/rotate-image/
*
* Approach 1: Do changes layer by layer like an onion.
* There will be total N/2 layers for N*N matrix
* For every layer, swap elements in group of 4.
* Time Complexity - O(N^2) Space Complexity - O(1)
*
*
* Approach 2: Transpose + Flip Horizontally = Clockwise Rotation
* Much easier to write code and understand as compared to Approach 1
* Same Time and Space Complexity
*/
class Solution {

    //Approach 1
    public void rotate_1(int[][] matrix) {
        if(matrix == null || matrix.length <= 1) return;
        
        int n = matrix.length-1;
        //Number of cycles
        for(int i = 0; i <= n/2; i++) {
            //Swapping elements in group of 4
            for(int j = i; j < n - i; j++) {
                
                int temp = matrix[i][j];
                //Move left element to top 
                matrix[i][j] = matrix[n-j][i];
                
                //Move bottom element to left
                matrix[n-j][i] = matrix[n-i][n-j];
                //Move right element to bottom;
                matrix[n-i][n-j] = matrix[j][n-i]; 
                //Move top element to right
                matrix[j][n-i] = temp;
            }
            
        }
    }
    
    //Approach: 2
    public void rotate_2(int[][] matrix) {
        if(matrix == null || matrix.length <= 1) return;
        
        int N = matrix.length;
        //Transpose the matrix
        transpose(matrix, N);
        flipHorizontally(matrix, N);
    }
    
    private void transpose(int[][] A, int N) {
        for(int i = 0; i < N; i++) { 
            for(int j = i; j < N; j++) {
                int tmp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = tmp;
            }
        }
    }
    
    private void flipHorizontally(int[][] A, int N) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N/2; j++) {
                int tmp = A[i][j];
                A[i][j] = A[i][N-1-j];
                A[i][N-1-j] = tmp;
            }
        }
    }
}
