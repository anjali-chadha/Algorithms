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
