//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    //Priority Queue
    public int findKthLargest1(int[] nums, int k) {
        if(nums == null || nums.length == 0) return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i: nums) {
            pq.offer(i);
            if(pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
