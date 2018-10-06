class Solution {
    
    // Not very elegant solution
    // Time Complexity - O(n^2) where n is the number of characters in the string
    //Space Complexity - O(n^2) as we are creating new string for every comparison
    public boolean rotateString_v1(String A, String B) {
        if(A == null || B == null) {return false;}
        int n = A.length();
        
        if(n != B.length()) {return false;}
        if(A.equals(B)) {
            return true;
        }
        
        String tmp = null;
        for(int i = 0; i < n - 1; i++) {  
            tmp = B.substring(i + 1) + B.substring(0, i + 1);
            if(A.equals(tmp)) {
                return true;
            } 
        }
        return false;
    }
    
    /** Simple & Elegant Solution
    * Time Complexity Breakdown: 
    * 1) String Concatenation - O(m+n) --> O(n) 
    * 2) String searching - O(m*n) --> O(n*n)
    public boolean rotateString(String A, String B) {
        if(A == null || B == null) {return false;}
        return A.length() == B.length() && (B+B).contains(A);
    }
}
