/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    public boolean val;
    public TrieNode[] next;
    
    public TrieNode() {
        val = false;
        next = new TrieNode[256];
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root = insert(root, word, 0);
    }
    
    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        if (d == word.length()) {
            x.val = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c] = insert(x.next[c], word, d + 1);
        return x;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode x = search(root, word, 0);
        if (x == null) {
            return false;
        }
        return x.val;
    }
    
    public TrieNode search(TrieNode x, String word, int d) {
        if (x == null) {
            return null;
        }
        if (d == word.length()) {
            return x;
        }
        char c = word.charAt(d);
        return search(x.next[c], word, d + 1);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return true;
        }
        TrieNode x = search(root, prefix, 0);
        if (x != null) {
            return true;
        }
        return false;
    }
}
