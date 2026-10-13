class WordDictionary {

    class Node {
        Node[] children = new Node[26];
        boolean eow;
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
        return dfs(word, root, 0);
    }

    private boolean dfs(String word, Node curr, int idx) {
        if (curr == null) {
            return false;
        }

        if (idx == word.length()) {
            return curr.eow;
        }

        char c = word.charAt(idx);

        // Case 1: Agar character '.' wildcard hai
        if (c == '.') {
            // Har possible child branch par DFS 
            for (int i = 0; i < 26; i++) {
                if (curr.children[i] != null && dfs(word, curr.children[i], idx + 1)) {
                    return true;
                }
            }
            return false;
        } 
        // Case 2: Regular lowercase character
        else {
            int childIndex = c - 'a';
            return dfs(word, curr.children[childIndex], idx + 1);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */