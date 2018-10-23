//https://leetcode.com/problems/3sum-closest/
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null || nums.length == 0) return 0;
        
        Arrays.sort(nums);
        
        int closestSum = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(closestSum - target);
        
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            int sum = target - nums[i];
            while(lo < hi) {
                if(nums[lo] + nums[hi] == sum) return target;
                else {
                    int diff = Math.abs(nums[lo] + nums[hi] - sum);
                    if(diff < minDiff) {
                        minDiff = diff;
                        closestSum = nums[lo] + nums[hi] + nums[i];
                    }
                    if(nums[lo] + nums[hi] > sum) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
        }
        return closestSum;
    }
}
