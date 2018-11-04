/*
Algorithm 1: Brute Force
O(N^2) - Tryiing every pair present in the array

Algorithm 2: One Pass of the array
O(N) - Time, O(1) Space
Maintain two variables - minPrice and maxProfit until this index of the array
*/
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) return 0;
        
        int minPrice = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] < minPrice) minPrice = prices[i];
            else if((prices[i] - minPrice) > maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
