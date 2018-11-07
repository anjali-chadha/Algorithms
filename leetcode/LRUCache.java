class LRUCache {

    private int capacity;
    private int size;
    private Map<Integer, Node> keyLLMap;
    private Node head;
    private Node tail;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        keyLLMap = new HashMap<>();
        head = new Node(-1, -1); //Dummy Nodes
        tail = new Node(-1, -1);
        tail.pre = head;
        head.next = tail;
    }
    
    private void deleteDLL(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }
    
    public int get(int key) {
        if(keyLLMap.containsKey(key)) {
            Node val = keyLLMap.get(key);
            deleteDLL(val);
            addToHead(val);
            return val.val;
        } 
        return -1;
    }
    
    public void put(int key, int value) {
        if(keyLLMap.containsKey(key)) {
            deleteDLL(keyLLMap.get(key));
            Node newNode = new Node(key, value);
            keyLLMap.put(key, newNode);
            addToHead(newNode);
        } else {
            Node node = new Node(key, value);
            keyLLMap.put(key, node);
            if(size < capacity) {
                size++;
            } else {
                keyLLMap.remove(tail.pre.key);
                deleteDLL(tail.pre);
            }
             addToHead(node); 
        }
       
    }
    
    class Node {
        int key, val;
        Node pre, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
