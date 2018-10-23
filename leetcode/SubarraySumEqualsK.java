//https://leetcode.com/problems/subarray-sum-equals-k/
class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        
        int n = nums.length;
        int sum = 0;
        int count = 0;
        
        Map<Integer, Integer> sumFrequencies = new HashMap<>();
        sumFrequencies.put(0, 1);
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            if(sumFrequencies.containsKey(sum - k)) {
                count += sumFrequencies.get(sum - k);
            }
            sumFrequencies.put(sum, sumFrequencies.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
