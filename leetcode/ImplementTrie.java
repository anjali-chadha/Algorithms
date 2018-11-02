/**
https://leetcode.com/problems/implement-trie-prefix-tree/

Time Complexity - 
  Search - O(M), Insert - O(M), SearchPrefix - O(M)

Questions:
Character set that can be provided as input
**/
class Trie {

    
    static class TrieNode {
        int SIZE = 26; //128 (Ask interviewer)
        private boolean isEnd = false;
        private TrieNode[] children;
        
        TrieNode() {
            children = new TrieNode[SIZE];
        }
    }
 
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return curr.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            int idx = c - 'a';
            if(curr.children[idx] == null) return false;
            curr = curr.children[idx];
        }
        return true;
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
