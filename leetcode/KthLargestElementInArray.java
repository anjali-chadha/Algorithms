/* 
https://leetcode.com/problems/kth-largest-element-in-an-array/

Alogrithm 1: 
Sort the input array. Access the element by index K
Time complexity - O(NlogN)
Space Complexity - O(1)

Algorithm 2: (Implemented Below)
Using Priority Queue (Java) minHeap
Time Complexity - O(N logK)
Space Complexity - O(K)

Algorithm 3: 
Quick Select (similar to Quick Sort - stop when pivot element's index is equal to K)
Worst case - O(N^2), Average Case - O(N)
*/
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
