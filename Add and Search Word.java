public class WordDictionary {
    private TrieNode root;

    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        root = addWord(root, word, 0);
    }
    
    private TrieNode addWord(TrieNode x, String word, int d) {
        if (x == null) {
            x = new TrieNode();
        }
        if (d == word.length()) {
            x.val = true;
            return x;
        }
        char c = word.charAt(d);
        x.next[c - 'a'] = addWord(x.next[c - 'a'], word, d + 1);
        return x;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return searchHelper(word, root, 0);
    }
    
    public boolean searchHelper(String word, TrieNode x, int d) {
        if (x == null) {
            return false;
        }
        if (d == word.length() && x != null && x.val == true) {
            return true;
        }
        if (d == word.length()) {
            return false;
        }
        char next = word.charAt(d);
        for (int c = 0; c < 26; c++) {
            if (next == '.' || next - 'a' == c) {
                if (searchHelper(word, x.next[c], d + 1) == true) {
                    return true;
                }
            }
        }
        return false;
    }
}

class TrieNode {
    // Initialize your data structure here.
    public boolean val;
    public TrieNode[] next;
    
    public TrieNode() {
        val = false;
        next = new TrieNode[26];
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");