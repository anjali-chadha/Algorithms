/*
Algorithm 1: sorting
Time - O(N log N), Space - O(N)

Algorithm 2: Heap
Using Heap
Time - O(N log K)
Space O(N)

*/
class Solution {
    
    //Algorithm 1
    public List<String> topKFrequent1(String[] words, int k) {
        List<String> result = null;
        if(words == null || words.length == 0) return result;
        
        Map<String, Integer> countMap = new HashMap<>();
        for(String item: words) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }
        
        result = new ArrayList<>(countMap.keySet());
        Collections.sort(result, (a, b) 
                         -> (countMap.get(a) == countMap.get(b))? a.compareTo(b): 
                         -1 * Integer.compare(countMap.get(a), countMap.get(b)));
        return result.subList(0, k);
    }
    
    //Algorithm 2
    public List<String> topKFrequent2(String[] words, int k) {
        List<String> result = null;
        if(words == null || words.length == 0) return result;
        
        Map<String, Integer> countMap = new HashMap<>();
        for(String item: words) {
            countMap.put(item, countMap.getOrDefault(item, 0) + 1);
        }
        
        PriorityQueue<String> minHeap = new PriorityQueue<>(
        (p, q) -> countMap.get(p) == countMap.get(q)? -1 * p.compareTo(q): 
            Integer.compare(countMap.get(p), countMap.get(q)));
        
        for(String item: countMap.keySet()) {
            minHeap.offer(item);
            if(minHeap.size() >= (k + 1)) minHeap.poll();
        }
        
        result = new ArrayList<>();
        while(!minHeap.isEmpty()) result.add(minHeap.poll());
        Collections.reverse(result);
        return result;
    }
}T
