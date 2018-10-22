//https://leetcode.com/problems/top-k-frequent-elements/
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        if(nums == null || nums.length == 0 || k <= 0) return result;
        
        int max = 0;
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for(int i: nums) {
            int oldVal = frequencyCount.getOrDefault(i, 0);
            if(oldVal + 1 > max) max = oldVal + 1;
            frequencyCount.put(i, oldVal + 1);
        }
        
        List<Integer>[] bucketSort = new ArrayList[max+1];
        for(Map.Entry<Integer, Integer> e: frequencyCount.entrySet()) {
            int num = e.getKey();
            int freq = e.getValue();
      
            if(bucketSort[freq] == null) {
                bucketSort[freq] = new ArrayList<Integer>();
            }
            bucketSort[freq].add(num);
        }
        
        for(int i = max; i > 0; i--) {
            if(bucketSort[i] == null) continue;
            for(int item: bucketSort[i]) {
                if(result.size() == k) break;
                result.add(item);
            }
        }
        return result;
    }
}
