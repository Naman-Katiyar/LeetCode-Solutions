class Solution {
    class Node {
        Node children [] = new Node [26];
        boolean eow;     
    }

    Node root = new Node ();
    
    //Insert Function
    public void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node ();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    //Search Function
    public boolean search(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }
        return curr.eow == true;
    }

    //Helper Fnx
    HashMap<String, Boolean> memo = new HashMap<>();
    //HashMap is used to improve TC and make searching faster by storing already computed result for the same substring in HashMap in any previous step, when a long string of repetitive characters are need to be searched like s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
    public boolean isContain(String s) {
        //Base Case
        if (s.length() == 0) {
            return true;
        } 

        if(memo.containsKey(s)) {
            return memo.get(s);
        }

        for (int i = 1; i <= s.length(); i++) {
            if ((search(s.substring(0, i))) && (isContain(s.substring(i)))) {
                memo.put(s, true);
                return true;
            }
        }
        memo.put(s, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        //Step 1: Make a Trie
        for (int i = 0; i < wordDict.size(); i++) {
            insert(wordDict.get(i));
        }

        return isContain(s);
    }
}