/*
https://leetcode.com/problems/product-of-array-except-self/description/

Algorithm 1: Time and Space Complexity - O(N)
Use separate arrays for storing left and right products
Then in final step combine them

Algorithm 2: Time = O(N), Space - O(1)
No need to use extra memory - left and right arrays.
Use two passes and store result in single array.

Algorithm 3: Convert the product to addition by using logarithm and antilogarithm
Time - O(N) Space - O(1)

*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0) return null;
        int n = nums.length;
        int[] prod = new int[n];
        
        int runningPrefix = 1;
        for(int i = 0; i < n; i++) {
            prod[i] = runningPrefix;
            runningPrefix *= nums[i];
        }        
        
        int runningSuffix = 1;
        for(int i = n-1; i >= 0; i--) {
            prod[i] *= runningSuffix;
            runningSuffix *= nums[i];
        }
        return prod;
    }
}
