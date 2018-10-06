//https://leetcode.com/problems/insert-delete-getrandom-o1/description/
class RandomizedSet {

    private List<Integer> A;
    private Map<Integer, Integer> map;
    private Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        A = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();    
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        int size = A.size();
        A.add(val);
        map.put(val, size);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int idx = map.get(val);
        
        int size = A.size();
        if(idx + 1 != size) {
            int lastElement = A.get(size - 1);
            A.set(idx, lastElement);
            map.put(lastElement, idx);
        }
        A.remove(size-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        random = new Random();
        return A.get(random.nextInt(A.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
