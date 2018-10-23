//https://leetcode.com/problems/find-pivot-index/
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        
        int totalSum = 0;
        for(int i: nums) totalSum += i;
        
        int runningSum = 0;
        for(int i = 0; i < nums.length; i++) {
            int leftSum = runningSum;
            int rightSum = totalSum - leftSum - nums[i];
            if(leftSum == rightSum) return i;
            runningSum += nums[i];
        }
        return -1;
    }
}
